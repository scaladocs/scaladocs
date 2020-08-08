function identity(x) { 
  return x;
}

function render(config) {
  var container = document.querySelector(".list-container");
  // Clear Old Links
  Array.from(container.childNodes).forEach(child =>
    container.removeChild(child)
  );

  // Add New Links
  var total = config.length;
  config.forEach((element, index) => {
    [
      renderSingleElement(element, index, total),
      ...renderChildrenElements(element.childMatch ? element.children || [] : [], index, total)
    ].forEach(link => {
      // Add it to the document to make it visible
      container.appendChild(link)
    });
  });
}

function renderChildrenElements(children, index, total) {
  return children.map(link => renderSingleElement(link, index, total, true));
}

function renderSingleElement(element, index, total, isChild) {
  const className = isChild ? "child" : '';

  // Build Clickable Styled Link Element with Title and URL
  var link = document.createElement("a");
  link.href = element.url;
  //link.target = "_blank";
  link.className = className;
  link.style.opacity = 1 - 0.5 * (index + 1) / total;

  // Build Styled Bookmark Title
  var linkText = document.createElement("span");
  linkText.innerText = element.title;
  linkText.style.transform = "scale(" + (1 - 0.5 * (index + 1) / total) + ")";
  link.appendChild(linkText);

  // Build Styled Link URL
  var packageUrl = [element.package, element.title].filter(identity).join('.');
  if (packageUrl !== element.title) {
    var linkUrl = document.createElement("span");
    linkUrl.innerText = " (" + packageUrl + ")";
    linkUrl.style.transform = "scale(" + (1 - 0.5 * (index + 2) / total) + ")";
    linkUrl.style.opacity = 0.7;
    link.appendChild(linkUrl);
  }

  return link;
}

function normalize(input) {
  return (input || "").toLowerCase();
}

function anchorCompare(input) {
  const normalizedInputValue = normalize(input.value);
  return (candidateString) => 
    compareTwoStrings(normalizedInputValue, normalize(candidateString));
}

function sortResults(input) {
  const compareToInput = anchorCompare(input);

  const newConfig = configuration.map(item => {
    const children = item.children || [];
    const childScores = children.map(child => compareToInput(child.title));
    const score = compareToInput(item.title);
    item.score = Math.max.apply(null, [score, ...childScores]);
    item.childMatch = score < item.score || score == 1;

    return item;
  });

  newConfig.sort((a, b) => b.score - a.score);
  render(newConfig);
}

function compareTwoStrings(string1, string2) {
  // Algorithm from: https://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Dice%27s_coefficient#Javascript
  var intersection = 0;
  var length1 = string1.length - 1;
  var length2 = string2.length - 1;
  if (length1 < 1 || length2 < 1) return 0;
  var bigrams2 = [];
  for (var i = 0; i < length2; i++) {
    bigrams2.push(string2.substr(i, 2));
  }
  for (var i = 0; i < length1; i++) {
    var bigram1 = string1.substr(i, 2);
    for (var j = 0; j < length2; j++) {
      if (bigram1 == bigrams2[j]) {
        intersection++;
        bigrams2[j] = null;
        break;
      }
    }
  }
  return 2.0 * intersection / (length1 + length2);
}

function toggleSearch() {
  document
    .getElementById('search-ui')
    .classList.toggle("hidden");
}

window.onload = () => {
  render(configuration.sort((a, b) => a.title.localeCompare(b.title)));
}
