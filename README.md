# scaladocs

Source code for [scaladocs.com](https://scaladocs.com).

## Why does ScalaDocs Exist?

ScalaDocs exists to make the Scala programming language, and its libraries
approachable to all members of the community through simple examples.

## Running the Project Locally

1. Install [`mill`][mill-build-tool]
2. Clone this repository onto your development environment.
3. Run the `docs` project and `http` server projects.
    - Terminal A: `mill --watch docs.run` (Code changes will automatically regenerate content)
    - Terminal B: `mill --watch http.runBackground` (Code changes restart server automatically)
4. Visit: [`http://localhost:8000`][localhost] in your favorite browser.

## License

The content of this project itself is licensed under the 
[Creative Commons Attribution-ShareAlike 4.0 International][cc-by-sa-4.0], 
and the underlying source code used to generate that content is licensed 
under the [AGPL license][license].

[cc-by-sa-4.0]: https://creativecommons.org/licenses/by-sa/4.0/ "Content License"
[license]: LICENSE "AGPL License"
[mill-build-tool]: http://www.lihaoyi.com/mill/ "Mill Build Tool" 
[localhost]: http://localhost:8000 "Localhost ScalaDocs"
