#  Expense Splitter Web Application

A full-stack web application to manage shared expenses and balances among groups or friends.  
Built using **Spring Boot** for the backend and **Vue.js** for the frontend.

---

##  Project Structure

Expense-Splitter-VAC/
├───backend
│   ├───.mvn
│   │   └───wrapper
│   ├───.settings
│   ├───src
│   │   ├───main
│   │   │   ├───java
│   │   │   │   └───com
│   │   │   │       └───ssn
│   │   │   │           └───esa
│   │   │   │               ├───controller
│   │   │   │               ├───dto
│   │   │   │               ├───entity
│   │   │   │               ├───exception
│   │   │   │               ├───repository
│   │   │   │               └───service
│   │   │   └───resources
│   │   │       ├───static
│   │   │       └───templates
│   │   └───test
│   │       └───java
│   │           └───com
│   │               └───ssn
│   │                   └───esa
│   └───target
│       ├───classes
│       │   └───com
│       │       └───ssn
│       │           └───esa
│       │               ├───controller
│       │               ├───dto
│       │               ├───entity
│       │               ├───exception
│       │               ├───repository
│       │               └───service
│       ├───generated-sources
│       │   └───annotations
│       ├───maven-status
│       │   └───maven-compiler-plugin
│       │       └───compile
│       │           └───default-compile
│       └───test-classes
│           └───com
│               └───ssn
│                   └───esa
└───frontend
    ├───.vscode
    ├───node_modules
    │   ├───.bin
    │   ├───.vite
    │   │   └───deps
    │   ├───.vite-temp
    │   ├───.vue-global-types
    │   ├───@alloc
    │   │   └───quick-lru
    │   ├───@asamuzakjp
    │   │   ├───css-color
    │   │   │   ├───dist
    │   │   │   │   ├───browser
    │   │   │   │   ├───cjs
    │   │   │   │   └───esm
    │   │   │   │       └───js
    │   │   │   └───src
    │   │   │       └───js
    │   │   ├───dom-selector
    │   │   │   ├───dist
    │   │   │   │   └───cjs
    │   │   │   ├───src
    │   │   │   │   └───js
    │   │   │   └───types
    │   │   │       └───js
    │   │   └───nwsapi
    │   │       └───src
    │   ├───@babel
    │   │   ├───code-frame
    │   │   │   └───lib
    │   │   ├───compat-data
    │   │   │   └───data
    │   │   ├───core
    │   │   │   ├───lib
    │   │   │   │   ├───config
    │   │   │   │   │   ├───files
    │   │   │   │   │   ├───helpers
    │   │   │   │   │   └───validation
    │   │   │   │   ├───errors
    │   │   │   │   ├───gensync-utils
    │   │   │   │   ├───parser
    │   │   │   │   │   └───util
    │   │   │   │   ├───tools
    │   │   │   │   ├───transformation
    │   │   │   │   │   ├───file
    │   │   │   │   │   └───util
    │   │   │   │   └───vendor
    │   │   │   ├───node_modules
    │   │   │   │   ├───.bin
    │   │   │   │   └───semver
    │   │   │   │       └───bin
    │   │   │   └───src
    │   │   │       └───config
    │   │   │           └───files
    │   │   ├───generator
    │   │   │   └───lib
    │   │   │       ├───generators
    │   │   │       └───node
    │   │   ├───helper-annotate-as-pure
    │   │   │   └───lib
    │   │   ├───helper-compilation-targets
    │   │   │   ├───lib
    │   │   │   └───node_modules
    │   │   │       ├───.bin
    │   │   │       ├───lru-cache
    │   │   │       └───semver
    │   │   │           └───bin
    │   │   ├───helper-create-class-features-plugin
    │   │   │   ├───lib
    │   │   │   └───node_modules
    │   │   │       ├───.bin
    │   │   │       └───semver
    │   │   │           └───bin
    │   │   ├───helper-globals
    │   │   │   └───data
    │   │   ├───helper-member-expression-to-functions
    │   │   │   └───lib
    │   │   ├───helper-module-imports
    │   │   │   └───lib
    │   │   ├───helper-module-transforms
    │   │   │   └───lib
    │   │   ├───helper-optimise-call-expression
    │   │   │   └───lib
    │   │   ├───helper-plugin-utils
    │   │   │   └───lib
    │   │   ├───helper-replace-supers
    │   │   │   └───lib
    │   │   ├───helper-skip-transparent-expression-wrappers
    │   │   │   └───lib
    │   │   ├───helper-string-parser
    │   │   │   └───lib
    │   │   ├───helper-validator-identifier
    │   │   │   └───lib
    │   │   ├───helper-validator-option
    │   │   │   └───lib
    │   │   ├───helpers
    │   │   │   └───lib
    │   │   │       └───helpers
    │   │   ├───parser
    │   │   │   ├───bin
    │   │   │   ├───lib
    │   │   │   └───typings
    │   │   ├───plugin-proposal-decorators
    │   │   │   └───lib
    │   │   ├───plugin-syntax-decorators
    │   │   │   └───lib
    │   │   ├───plugin-syntax-import-attributes
    │   │   │   └───lib
    │   │   ├───plugin-syntax-import-meta
    │   │   │   └───lib
    │   │   ├───plugin-syntax-jsx
    │   │   │   └───lib
    │   │   ├───plugin-syntax-typescript
    │   │   │   └───lib
    │   │   ├───plugin-transform-typescript
    │   │   │   └───lib
    │   │   ├───template
    │   │   │   └───lib
    │   │   ├───traverse
    │   │   │   └───lib
    │   │   │       ├───path
    │   │   │       │   ├───inference
    │   │   │       │   └───lib
    │   │   │       └───scope
    │   │   │           └───lib
    │   │   └───types
    │   │       └───lib
    │   │           ├───asserts
    │   │           │   └───generated
    │   │           ├───ast-types
    │   │           │   └───generated
    │   │           ├───builders
    │   │           │   ├───flow
    │   │           │   ├───generated
    │   │           │   ├───react
    │   │           │   └───typescript
    │   │           ├───clone
    │   │           ├───comments
    │   │           ├───constants
    │   │           │   └───generated
    │   │           ├───converters
    │   │           ├───definitions
    │   │           ├───modifications
    │   │           │   ├───flow
    │   │           │   └───typescript
    │   │           ├───retrievers
    │   │           ├───traverse
    │   │           ├───utils
    │   │           │   └───react
    │   │           └───validators
    │   │               ├───generated
    │   │               └───react
    │   ├───@csstools
    │   │   ├───color-helpers
    │   │   │   └───dist
    │   │   ├───css-calc
    │   │   │   └───dist
    │   │   ├───css-color-parser
    │   │   │   └───dist
    │   │   ├───css-parser-algorithms
    │   │   │   └───dist
    │   │   ├───css-syntax-patches-for-csstree
    │   │   │   └───dist
    │   │   └───css-tokenizer
    │   │       └───dist
    │   ├───@esbuild
    │   │   └───darwin-arm64
    │   │       └───bin
    │   ├───@eslint
    │   │   ├───config-array
    │   │   │   ├───dist
    │   │   │   │   ├───cjs
    │   │   │   │   │   └───std__path
    │   │   │   │   └───esm
    │   │   │   │       └───std__path
    │   │   │   └───node_modules
    │   │   │       ├───brace-expansion
    │   │   │       └───minimatch
    │   │   ├───config-helpers
    │   │   │   └───dist
    │   │   │       ├───cjs
    │   │   │       └───esm
    │   │   ├───core
    │   │   │   └───dist
    │   │   │       ├───cjs
    │   │   │       └───esm
    │   │   ├───eslintrc
    │   │   │   ├───conf
    │   │   │   ├───dist
    │   │   │   ├───lib
    │   │   │   │   ├───config-array
    │   │   │   │   ├───shared
    │   │   │   │   └───types
    │   │   │   └───node_modules
    │   │   │       ├───brace-expansion
    │   │   │       ├───globals
    │   │   │       └───minimatch
    │   │   ├───js
    │   │   │   ├───src
    │   │   │   │   └───configs
    │   │   │   └───types
    │   │   ├───object-schema
    │   │   │   └───dist
    │   │   │       ├───cjs
    │   │   │       └───esm
    │   │   └───plugin-kit
    │   │       └───dist
    │   │           ├───cjs
    │   │           └───esm
    │   ├───@eslint-community
    │   │   ├───eslint-utils
    │   │   └───regexpp
    │   ├───@humanfs
    │   │   ├───core
    │   │   │   ├───dist
    │   │   │   └───src
    │   │   └───node
    │   │       ├───dist
    │   │       └───src
    │   ├───@humanwhocodes
    │   │   ├───module-importer
    │   │   │   ├───dist
    │   │   │   └───src
    │   │   └───retry
    │   │       └───dist
    │   ├───@isaacs
    │   │   └───cliui
    │   │       └───build
    │   │           └───lib
    │   ├───@jridgewell
    │   │   ├───gen-mapping
    │   │   │   ├───dist
    │   │   │   │   └───types
    │   │   │   ├───src
    │   │   │   └───types
    │   │   ├───remapping
    │   │   │   ├───dist
    │   │   │   ├───src
    │   │   │   └───types
    │   │   ├───resolve-uri
    │   │   │   └───dist
    │   │   │       └───types
    │   │   ├───sourcemap-codec
    │   │   │   ├───dist
    │   │   │   ├───src
    │   │   │   └───types
    │   │   └───trace-mapping
    │   │       ├───dist
    │   │       ├───src
    │   │       └───types
    │   ├───@nodelib
    │   │   ├───fs.scandir
    │   │   │   └───out
    │   │   │       ├───adapters
    │   │   │       ├───providers
    │   │   │       ├───types
    │   │   │       └───utils
    │   │   ├───fs.stat
    │   │   │   └───out
    │   │   │       ├───adapters
    │   │   │       ├───providers
    │   │   │       └───types
    │   │   └───fs.walk
    │   │       └───out
    │   │           ├───providers
    │   │           ├───readers
    │   │           └───types
    │   ├───@one-ini
    │   │   └───wasm
    │   ├───@pinia
    │   │   └───testing
    │   │       └───dist
    │   ├───@pkgjs
    │   │   └───parseargs
    │   │       ├───examples
    │   │       └───internal
    │   ├───@pkgr
    │   │   └───core
    │   │       └───lib
    │   ├───@polka
    │   │   └───url
    │   ├───@rolldown
    │   │   └───pluginutils
    │   │       └───dist
    │   ├───@rollup
    │   │   └───rollup-darwin-arm64
    │   ├───@types
    │   │   ├───chai
    │   │   ├───deep-eql
    │   │   ├───estree
    │   │   └───json-schema
    │   ├───@typescript-eslint
    │   │   ├───project-service
    │   │   │   └───dist
    │   │   ├───scope-manager
    │   │   │   └───dist
    │   │   │       ├───definition
    │   │   │       ├───lib
    │   │   │       ├───referencer
    │   │   │       ├───scope
    │   │   │       └───variable
    │   │   ├───tsconfig-utils
    │   │   │   └───dist
    │   │   ├───types
    │   │   │   └───dist
    │   │   │       └───generated
    │   │   ├───typescript-estree
    │   │   │   └───dist
    │   │   │       ├───create-program
    │   │   │       ├───jsx
    │   │   │       ├───parseSettings
    │   │   │       └───ts-estree
    │   │   ├───utils
    │   │   │   └───dist
    │   │   │       ├───ast-utils
    │   │   │       │   └───eslint-utils
    │   │   │       ├───eslint-utils
    │   │   │       ├───ts-eslint
    │   │   │       │   └───eslint
    │   │   │       └───ts-utils
    │   │   └───visitor-keys
    │   │       ├───dist
    │   │       └───node_modules
    │   │           └───eslint-visitor-keys
    │   │               ├───dist
    │   │               └───lib
    │   ├───@vitejs
    │   │   └───plugin-vue
    │   │       └───dist
    │   ├───@vitest
    │   │   ├───eslint-plugin
    │   │   │   └───dist
    │   │   ├───expect
    │   │   │   └───dist
    │   │   ├───mocker
    │   │   │   ├───dist
    │   │   │   └───node_modules
    │   │   │       └───estree-walker
    │   │   │           ├───src
    │   │   │           └───types
    │   │   ├───pretty-format
    │   │   │   └───dist
    │   │   ├───runner
    │   │   │   └───dist
    │   │   ├───snapshot
    │   │   │   └───dist
    │   │   ├───spy
    │   │   │   └───dist
    │   │   └───utils
    │   │       └───dist
    │   ├───@vue
    │   │   ├───babel-helper-vue-transform-on
    │   │   ├───babel-plugin-jsx
    │   │   │   └───dist
    │   │   ├───babel-plugin-resolve-type
    │   │   │   └───dist
    │   │   ├───compiler-core
    │   │   │   ├───dist
    │   │   │   └───node_modules
    │   │   │       └───entities
    │   │   │           └───lib
    │   │   │               ├───esm
    │   │   │               │   └───generated
    │   │   │               └───generated
    │   │   ├───compiler-dom
    │   │   │   └───dist
    │   │   ├───compiler-sfc
    │   │   │   └───dist
    │   │   ├───compiler-ssr
    │   │   │   └───dist
    │   │   ├───devtools-api
    │   │   │   └───dist
    │   │   ├───devtools-core
    │   │   │   ├───dist
    │   │   │   └───node_modules
    │   │   │       ├───.bin
    │   │   │       ├───@vue
    │   │   │       │   ├───devtools-kit
    │   │   │       │   │   └───dist
    │   │   │       │   └───devtools-shared
    │   │   │       │       └───dist
    │   │   │       ├───nanoid
    │   │   │       │   ├───bin
    │   │   │       │   ├───non-secure
    │   │   │       │   └───url-alphabet
    │   │   │       └───perfect-debounce
    │   │   │           └───dist
    │   │   ├───devtools-kit
    │   │   │   └───dist
    │   │   ├───devtools-shared
    │   │   │   └───dist
    │   │   ├───eslint-config-prettier
    │   │   ├───reactivity
    │   │   │   └───dist
    │   │   ├───runtime-core
    │   │   │   └───dist
    │   │   ├───runtime-dom
    │   │   │   └───dist
    │   │   ├───server-renderer
    │   │   │   └───dist
    │   │   ├───shared
    │   │   │   └───dist
    │   │   └───test-utils
    │   │       └───dist
    │   │           ├───components
    │   │           ├───constants
    │   │           ├───interfaces
    │   │           ├───utils
    │   │           └───vnodeTransformers
    │   ├───abbrev
    │   │   └───lib
    │   ├───acorn
    │   │   ├───bin
    │   │   └───dist
    │   ├───acorn-jsx
    │   ├───agent-base
    │   │   └───dist
    │   ├───ajv
    │   │   ├───dist
    │   │   ├───lib
    │   │   │   ├───compile
    │   │   │   ├───dot
    │   │   │   ├───dotjs
    │   │   │   └───refs
    │   │   └───scripts
    │   ├───ansi-regex
    │   ├───ansi-styles
    │   ├───ansis
    │   ├───any-promise
    │   │   └───register
    │   ├───anymatch
    │   ├───arg
    │   ├───argparse
    │   │   └───lib
    │   ├───assertion-error
    │   ├───asynckit
    │   │   └───lib
    │   ├───autoprefixer
    │   │   ├───bin
    │   │   ├───data
    │   │   └───lib
    │   │       └───hacks
    │   ├───axios
    │   │   ├───dist
    │   │   │   ├───browser
    │   │   │   ├───esm
    │   │   │   └───node
    │   │   └───lib
    │   │       ├───adapters
    │   │       ├───cancel
    │   │       ├───core
    │   │       ├───defaults
    │   │       ├───env
    │   │       │   └───classes
    │   │       ├───helpers
    │   │       └───platform
    │   │           ├───browser
    │   │           │   └───classes
    │   │           ├───common
    │   │           └───node
    │   │               └───classes
    │   ├───balanced-match
    │   │   └───.github
    │   ├───baseline-browser-mapping
    │   │   └───dist
    │   ├───bidi-js
    │   │   ├───dist
    │   │   └───src
    │   │       ├───data
    │   │       └───util
    │   ├───binary-extensions
    │   ├───birpc
    │   │   └───dist
    │   ├───boolbase
    │   ├───brace-expansion
    │   │   └───.github
    │   ├───braces
    │   │   └───lib
    │   ├───browserslist
    │   ├───bundle-name
    │   ├───cac
    │   │   ├───deno
    │   │   └───dist
    │   ├───call-bind-apply-helpers
    │   │   ├───.github
    │   │   └───test
    │   ├───callsites
    │   ├───camelcase-css
    │   ├───caniuse-lite
    │   │   ├───data
    │   │   │   ├───features
    │   │   │   └───regions
    │   │   └───dist
    │   │       ├───lib
    │   │       └───unpacker
    │   ├───chai
    │   │   └───lib
    │   │       └───chai
    │   │           ├───core
    │   │           ├───interface
    │   │           └───utils
    │   ├───chalk
    │   │   └───source
    │   ├───check-error
    │   ├───chokidar
    │   │   ├───lib
    │   │   ├───node_modules
    │   │   │   └───glob-parent
    │   │   └───types
    │   ├───color-convert
    │   ├───color-name
    │   ├───combined-stream
    │   │   └───lib
    │   ├───commander
    │   │   ├───lib
    │   │   └───typings
    │   ├───concat-map
    │   │   ├───example
    │   │   └───test
    │   ├───config-chain
    │   ├───convert-source-map
    │   ├───copy-anything
    │   │   └───dist
    │   ├───cross-spawn
    │   │   └───lib
    │   │       └───util
    │   ├───css-tree
    │   │   ├───cjs
    │   │   │   ├───convertor
    │   │   │   ├───definition-syntax
    │   │   │   ├───generator
    │   │   │   ├───lexer
    │   │   │   ├───parser
    │   │   │   ├───syntax
    │   │   │   │   ├───atrule
    │   │   │   │   ├───config
    │   │   │   │   ├───function
    │   │   │   │   ├───node
    │   │   │   │   │   └───common
    │   │   │   │   ├───pseudo
    │   │   │   │   └───scope
    │   │   │   ├───tokenizer
    │   │   │   ├───utils
    │   │   │   └───walker
    │   │   ├───data
    │   │   ├───dist
    │   │   └───lib
    │   │       ├───convertor
    │   │       ├───definition-syntax
    │   │       ├───generator
    │   │       ├───lexer
    │   │       ├───parser
    │   │       ├───syntax
    │   │       │   ├───atrule
    │   │       │   ├───config
    │   │       │   ├───function
    │   │       │   ├───node
    │   │       │   ├───pseudo
    │   │       │   └───scope
    │   │       ├───tokenizer
    │   │       ├───utils
    │   │       └───walker
    │   ├───cssesc
    │   │   ├───bin
    │   │   └───man
    │   ├───cssstyle
    │   │   └───lib
    │   │       ├───generated
    │   │       ├───properties
    │   │       └───utils
    │   ├───csstype
    │   ├───data-urls
    │   │   └───lib
    │   ├───debug
    │   │   └───src
    │   ├───decimal.js
    │   ├───deep-eql
    │   ├───deep-is
    │   │   ├───example
    │   │   └───test
    │   ├───default-browser
    │   ├───default-browser-id
    │   ├───define-lazy-prop
    │   ├───delayed-stream
    │   │   └───lib
    │   ├───didyoumean
    │   ├───dlv
    │   │   └───dist
    │   ├───dunder-proto
    │   │   ├───.github
    │   │   └───test
    │   ├───eastasianwidth
    │   ├───editorconfig
    │   │   ├───bin
    │   │   ├───lib
    │   │   └───node_modules
    │   │       └───minimatch
    │   │           └───dist
    │   │               ├───cjs
    │   │               └───mjs
    │   ├───electron-to-chromium
    │   ├───emoji-regex
    │   │   └───es2015
    │   ├───entities
    │   │   ├───dist
    │   │   │   ├───commonjs
    │   │   │   │   └───generated
    │   │   │   └───esm
    │   │   │       └───generated
    │   │   └───src
    │   │       └───generated
    │   ├───error-stack-parser-es
    │   │   └───dist
    │   ├───es-define-property
    │   │   ├───.github
    │   │   └───test
    │   ├───es-errors
    │   │   ├───.github
    │   │   └───test
    │   ├───es-module-lexer
    │   │   ├───dist
    │   │   └───types
    │   ├───es-object-atoms
    │   │   ├───.github
    │   │   └───test
    │   ├───es-set-tostringtag
    │   │   └───test
    │   ├───esbuild
    │   │   ├───bin
    │   │   └───lib
    │   ├───escalade
    │   │   ├───dist
    │   │   └───sync
    │   ├───escape-string-regexp
    │   ├───eslint
    │   │   ├───bin
    │   │   ├───conf
    │   │   ├───lib
    │   │   │   ├───cli-engine
    │   │   │   │   └───formatters
    │   │   │   ├───config
    │   │   │   ├───eslint
    │   │   │   ├───languages
    │   │   │   │   └───js
    │   │   │   │       └───source-code
    │   │   │   │           └───token-store
    │   │   │   ├───linter
    │   │   │   │   └───code-path-analysis
    │   │   │   ├───rule-tester
    │   │   │   ├───rules
    │   │   │   │   └───utils
    │   │   │   │       └───unicode
    │   │   │   ├───services
    │   │   │   ├───shared
    │   │   │   └───types
    │   │   ├───messages
    │   │   └───node_modules
    │   │       ├───brace-expansion
    │   │       ├───eslint-visitor-keys
    │   │       │   ├───dist
    │   │       │   └───lib
    │   │       └───minimatch
    │   ├───eslint-config-prettier
    │   │   └───bin
    │   ├───eslint-plugin-prettier
    │   ├───eslint-plugin-vue
    │   │   └───lib
    │   │       ├───configs
    │   │       │   └───flat
    │   │       ├───rules
    │   │       │   └───syntaxes
    │   │       │       └───utils
    │   │       └───utils
    │   │           ├───style-variables
    │   │           └───ts-utils
    │   ├───eslint-scope
    │   │   ├───dist
    │   │   └───lib
    │   ├───eslint-visitor-keys
    │   │   ├───dist
    │   │   └───lib
    │   ├───espree
    │   │   ├───dist
    │   │   ├───lib
    │   │   └───node_modules
    │   │       └───eslint-visitor-keys
    │   │           ├───dist
    │   │           └───lib
    │   ├───esquery
    │   │   └───dist
    │   ├───esrecurse
    │   ├───estraverse
    │   ├───estree-walker
    │   │   ├───dist
    │   │   │   ├───esm
    │   │   │   └───umd
    │   │   ├───src
    │   │   └───types
    │   ├───esutils
    │   │   └───lib
    │   ├───expect-type
    │   │   └───dist
    │   ├───fast-deep-equal
    │   │   └───es6
    │   ├───fast-diff
    │   ├───fast-glob
    │   │   ├───node_modules
    │   │   │   └───glob-parent
    │   │   └───out
    │   │       ├───managers
    │   │       ├───providers
    │   │       │   ├───filters
    │   │       │   ├───matchers
    │   │       │   └───transformers
    │   │       ├───readers
    │   │       ├───types
    │   │       └───utils
    │   ├───fast-json-stable-stringify
    │   │   ├───.github
    │   │   ├───benchmark
    │   │   ├───example
    │   │   └───test
    │   ├───fast-levenshtein
    │   ├───fastq
    │   │   ├───.github
    │   │   │   └───workflows
    │   │   └───test
    │   ├───file-entry-cache
    │   ├───fill-range
    │   ├───find-up
    │   ├───flat-cache
    │   │   └───src
    │   ├───flatted
    │   │   ├───cjs
    │   │   ├───esm
    │   │   ├───php
    │   │   ├───python
    │   │   └───types
    │   ├───follow-redirects
    │   ├───foreground-child
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───form-data
    │   │   └───lib
    │   ├───fraction.js
    │   ├───function-bind
    │   │   ├───.github
    │   │   └───test
    │   ├───gensync
    │   │   └───test
    │   ├───get-intrinsic
    │   │   ├───.github
    │   │   └───test
    │   ├───get-proto
    │   │   ├───.github
    │   │   └───test
    │   ├───glob
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───glob-parent
    │   ├───globals
    │   ├───gopd
    │   │   ├───.github
    │   │   └───test
    │   ├───has-flag
    │   ├───has-symbols
    │   │   ├───.github
    │   │   └───test
    │   │       └───shams
    │   ├───has-tostringtag
    │   │   ├───.github
    │   │   └───test
    │   │       └───shams
    │   ├───hasown
    │   │   └───.github
    │   ├───hookable
    │   │   └───dist
    │   ├───html-encoding-sniffer
    │   │   └───lib
    │   ├───http-proxy-agent
    │   │   └───dist
    │   ├───https-proxy-agent
    │   │   └───dist
    │   ├───iconv-lite
    │   │   ├───.github
    │   │   ├───.idea
    │   │   │   ├───codeStyles
    │   │   │   └───inspectionProfiles
    │   │   ├───encodings
    │   │   │   └───tables
    │   │   └───lib
    │   ├───ignore
    │   ├───import-fresh
    │   ├───imurmurhash
    │   ├───ini
    │   ├───is-binary-path
    │   ├───is-core-module
    │   │   └───test
    │   ├───is-docker
    │   ├───is-extglob
    │   ├───is-fullwidth-code-point
    │   ├───is-glob
    │   ├───is-inside-container
    │   ├───is-number
    │   ├───is-potential-custom-element-name
    │   ├───is-what
    │   │   └───dist
    │   ├───is-wsl
    │   ├───isexe
    │   │   └───test
    │   ├───jackspeak
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───jiti
    │   │   ├───bin
    │   │   ├───dist
    │   │   │   └───plugins
    │   │   └───lib
    │   ├───js-beautify
    │   │   └───js
    │   │       ├───bin
    │   │       ├───lib
    │   │       │   └───unpackers
    │   │       └───src
    │   │           ├───core
    │   │           ├───css
    │   │           ├───html
    │   │           ├───javascript
    │   │           └───unpackers
    │   ├───js-cookie
    │   │   └───dist
    │   ├───js-tokens
    │   ├───js-yaml
    │   │   ├───bin
    │   │   ├───dist
    │   │   └───lib
    │   │       ├───schema
    │   │       └───type
    │   ├───jsdom
    │   │   ├───lib
    │   │   │   └───jsdom
    │   │   │       ├───browser
    │   │   │       │   ├───parser
    │   │   │       │   └───resources
    │   │   │       ├───level2
    │   │   │       ├───level3
    │   │   │       └───living
    │   │   │           ├───aborting
    │   │   │           ├───attributes
    │   │   │           ├───constraint-validation
    │   │   │           ├───crypto
    │   │   │           ├───cssom
    │   │   │           ├───custom-elements
    │   │   │           ├───deviceorientation
    │   │   │           ├───domparsing
    │   │   │           ├───events
    │   │   │           ├───fetch
    │   │   │           ├───file-api
    │   │   │           ├───generated
    │   │   │           ├───geometry
    │   │   │           ├───helpers
    │   │   │           │   └───svg
    │   │   │           ├───hr-time
    │   │   │           ├───mutation-observer
    │   │   │           ├───navigator
    │   │   │           ├───nodes
    │   │   │           ├───range
    │   │   │           ├───selection
    │   │   │           ├───svg
    │   │   │           ├───traversal
    │   │   │           ├───webidl
    │   │   │           ├───websockets
    │   │   │           ├───webstorage
    │   │   │           ├───window
    │   │   │           └───xhr
    │   │   └───node_modules
    │   │       └───xml-name-validator
    │   │           └───lib
    │   ├───jsesc
    │   │   ├───bin
    │   │   └───man
    │   ├───json-buffer
    │   │   └───test
    │   ├───json-schema-traverse
    │   │   └───spec
    │   │       └───fixtures
    │   ├───json-stable-stringify-without-jsonify
    │   │   ├───example
    │   │   └───test
    │   ├───json5
    │   │   ├───dist
    │   │   └───lib
    │   ├───keyv
    │   │   └───src
    │   ├───kolorist
    │   │   └───dist
    │   │       ├───cjs
    │   │       ├───esm
    │   │       ├───module
    │   │       └───types
    │   ├───levn
    │   │   └───lib
    │   ├───lilconfig
    │   │   └───src
    │   ├───lines-and-columns
    │   │   └───build
    │   ├───locate-path
    │   ├───lodash.merge
    │   ├───loupe
    │   │   └───lib
    │   ├───lru-cache
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───magic-string
    │   │   └───dist
    │   ├───math-intrinsics
    │   │   ├───.github
    │   │   ├───constants
    │   │   └───test
    │   ├───mdn-data
    │   │   ├───api
    │   │   ├───css
    │   │   └───l10n
    │   ├───merge2
    │   ├───micromatch
    │   ├───mime-db
    │   ├───mime-types
    │   ├───minimatch
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───minipass
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───mitt
    │   │   └───dist
    │   ├───mrmime
    │   ├───ms
    │   ├───mz
    │   ├───nanoid
    │   │   ├───async
    │   │   ├───bin
    │   │   ├───non-secure
    │   │   └───url-alphabet
    │   ├───natural-compare
    │   ├───node-releases
    │   │   └───data
    │   │       ├───processed
    │   │       └───release-schedule
    │   ├───nopt
    │   │   ├───bin
    │   │   └───lib
    │   ├───normalize-path
    │   ├───normalize-range
    │   ├───nth-check
    │   │   └───lib
    │   │       └───esm
    │   ├───object-assign
    │   ├───object-hash
    │   │   └───dist
    │   ├───ohash
    │   │   └───dist
    │   │       ├───crypto
    │   │       │   ├───js
    │   │       │   └───node
    │   │       ├───shared
    │   │       └───utils
    │   ├───open
    │   ├───optionator
    │   │   └───lib
    │   ├───p-limit
    │   ├───p-locate
    │   ├───package-json-from-dist
    │   │   └───dist
    │   │       ├───commonjs
    │   │       └───esm
    │   ├───parent-module
    │   ├───parse5
    │   │   └───dist
    │   │       ├───common
    │   │       ├───parser
    │   │       ├───serializer
    │   │       ├───tokenizer
    │   │       └───tree-adapters
    │   ├───path-exists
    │   ├───path-key
    │   ├───path-parse
    │   ├───path-scurry
    │   │   ├───dist
    │   │   │   ├───commonjs
    │   │   │   └───esm
    │   │   └───node_modules
    │   │       └───lru-cache
    │   │           └───dist
    │   │               ├───commonjs
    │   │               └───esm
    │   ├───pathe
    │   │   └───dist
    │   │       └───shared
    │   ├───pathval
    │   ├───perfect-debounce
    │   │   └───dist
    │   ├───picocolors
    │   ├───picomatch
    │   │   └───lib
    │   ├───pify
    │   ├───pinia
    │   │   └───dist
    │   ├───pirates
    │   │   └───lib
    │   ├───postcss
    │   │   └───lib
    │   ├───postcss-import
    │   │   └───lib
    │   ├───postcss-js
    │   ├───postcss-load-config
    │   │   └───src
    │   ├───postcss-nested
    │   ├───postcss-selector-parser
    │   │   └───dist
    │   │       ├───selectors
    │   │       └───util
    │   ├───postcss-value-parser
    │   │   └───lib
    │   ├───prelude-ls
    │   │   └───lib
    │   ├───prettier
    │   │   ├───bin
    │   │   ├───internal
    │   │   └───plugins
    │   ├───prettier-linter-helpers
    │   │   ├───.github
    │   │   ├───.vscode
    │   │   └───test
    │   ├───proto-list
    │   │   └───test
    │   ├───proxy-from-env
    │   ├───punycode
    │   ├───queue-microtask
    │   ├───read-cache
    │   ├───readdirp
    │   ├───require-from-string
    │   ├───resolve
    │   │   ├───.github
    │   │   ├───bin
    │   │   ├───example
    │   │   ├───lib
    │   │   └───test
    │   │       ├───dotdot
    │   │       │   └───abc
    │   │       ├───module_dir
    │   │       │   ├───xmodules
    │   │       │   │   └───aaa
    │   │       │   ├───ymodules
    │   │       │   │   └───aaa
    │   │       │   └───zmodules
    │   │       │       └───bbb
    │   │       ├───node_path
    │   │       │   ├───x
    │   │       │   │   ├───aaa
    │   │       │   │   └───ccc
    │   │       │   └───y
    │   │       │       ├───bbb
    │   │       │       └───ccc
    │   │       ├───pathfilter
    │   │       │   └───deep_ref
    │   │       ├───precedence
    │   │       │   ├───aaa
    │   │       │   └───bbb
    │   │       ├───resolver
    │   │       │   ├───baz
    │   │       │   ├───browser_field
    │   │       │   ├───dot_main
    │   │       │   ├───dot_slash_main
    │   │       │   ├───false_main
    │   │       │   ├───incorrect_main
    │   │       │   ├───invalid_main
    │   │       │   ├───multirepo
    │   │       │   │   └───packages
    │   │       │   │       ├───package-a
    │   │       │   │       └───package-b
    │   │       │   ├───nested_symlinks
    │   │       │   │   └───mylib
    │   │       │   ├───other_path
    │   │       │   │   └───lib
    │   │       │   ├───quux
    │   │       │   │   └───foo
    │   │       │   ├───same_names
    │   │       │   │   └───foo
    │   │       │   ├───symlinked
    │   │       │   │   ├───package
    │   │       │   │   └───_
    │   │       │   │       ├───node_modules
    │   │       │   │       └───symlink_target
    │   │       │   └───without_basedir
    │   │       └───shadowed_core
    │   │           └───node_modules
    │   │               └───util
    │   ├───resolve-from
    │   ├───reusify
    │   │   ├───.github
    │   │   │   └───workflows
    │   │   └───benchmarks
    │   ├───rfdc
    │   │   ├───.github
    │   │   │   └───workflows
    │   │   └───test
    │   ├───rollup
    │   │   └───dist
    │   │       ├───bin
    │   │       ├───es
    │   │       │   └───shared
    │   │       └───shared
    │   ├───rrweb-cssom
    │   │   ├───build
    │   │   └───lib
    │   ├───run-applescript
    │   ├───run-parallel
    │   ├───safer-buffer
    │   ├───saxes
    │   ├───semver
    │   │   ├───bin
    │   │   ├───classes
    │   │   ├───functions
    │   │   ├───internal
    │   │   └───ranges
    │   ├───shebang-command
    │   ├───shebang-regex
    │   ├───siginfo
    │   ├───signal-exit
    │   │   └───dist
    │   │       ├───cjs
    │   │       └───mjs
    │   ├───sirv
    │   ├───source-map-js
    │   │   └───lib
    │   ├───speakingurl
    │   │   ├───examples
    │   │   ├───lib
    │   │   ├───test
    │   │   └───typings
    │   │       └───speakingurl
    │   ├───stackback
    │   ├───std-env
    │   │   └───dist
    │   ├───string-width
    │   ├───string-width-cjs
    │   │   └───node_modules
    │   │       ├───ansi-regex
    │   │       ├───emoji-regex
    │   │       │   └───es2015
    │   │       └───strip-ansi
    │   ├───strip-ansi
    │   ├───strip-ansi-cjs
    │   │   └───node_modules
    │   │       └───ansi-regex
    │   ├───strip-json-comments
    │   ├───strip-literal
    │   │   ├───dist
    │   │   └───node_modules
    │   │       └───js-tokens
    │   ├───sucrase
    │   │   ├───bin
    │   │   ├───dist
    │   │   │   ├───esm
    │   │   │   │   ├───parser
    │   │   │   │   │   ├───plugins
    │   │   │   │   │   │   └───jsx
    │   │   │   │   │   ├───tokenizer
    │   │   │   │   │   ├───traverser
    │   │   │   │   │   └───util
    │   │   │   │   ├───transformers
    │   │   │   │   └───util
    │   │   │   ├───parser
    │   │   │   │   ├───plugins
    │   │   │   │   │   └───jsx
    │   │   │   │   ├───tokenizer
    │   │   │   │   ├───traverser
    │   │   │   │   └───util
    │   │   │   ├───transformers
    │   │   │   ├───types
    │   │   │   │   ├───parser
    │   │   │   │   │   ├───plugins
    │   │   │   │   │   │   └───jsx
    │   │   │   │   │   ├───tokenizer
    │   │   │   │   │   ├───traverser
    │   │   │   │   │   └───util
    │   │   │   │   ├───transformers
    │   │   │   │   └───util
    │   │   │   └───util
    │   │   ├───node_modules
    │   │   │   └───commander
    │   │   │       └───typings
    │   │   ├───register
    │   │   └───ts-node-plugin
    │   ├───superjson
    │   │   ├───dist
    │   │   └───dist-cjs
    │   ├───supports-color
    │   ├───supports-preserve-symlinks-flag
    │   │   ├───.github
    │   │   └───test
    │   ├───symbol-tree
    │   │   └───lib
    │   ├───synckit
    │   │   └───lib
    │   ├───tailwindcss
    │   │   ├───lib
    │   │   │   ├───cli
    │   │   │   │   ├───build
    │   │   │   │   ├───help
    │   │   │   │   └───init
    │   │   │   ├───css
    │   │   │   ├───lib
    │   │   │   ├───postcss-plugins
    │   │   │   │   └───nesting
    │   │   │   ├───public
    │   │   │   ├───util
    │   │   │   └───value-parser
    │   │   ├───nesting
    │   │   ├───peers
    │   │   ├───scripts
    │   │   ├───src
    │   │   │   ├───cli
    │   │   │   │   ├───build
    │   │   │   │   ├───help
    │   │   │   │   └───init
    │   │   │   ├───css
    │   │   │   ├───lib
    │   │   │   ├───postcss-plugins
    │   │   │   │   └───nesting
    │   │   │   ├───public
    │   │   │   ├───util
    │   │   │   └───value-parser
    │   │   ├───stubs
    │   │   └───types
    │   │       └───generated
    │   ├───thenify
    │   ├───thenify-all
    │   ├───tinybench
    │   │   └───dist
    │   ├───tinyexec
    │   │   └───dist
    │   ├───tinyglobby
    │   │   ├───dist
    │   │   └───node_modules
    │   │       ├───fdir
    │   │       │   └───dist
    │   │       └───picomatch
    │   │           └───lib
    │   ├───tinypool
    │   │   └───dist
    │   │       └───entry
    │   ├───tinyrainbow
    │   │   └───dist
    │   ├───tinyspy
    │   │   └───dist
    │   ├───tldts
    │   │   ├───bin
    │   │   ├───dist
    │   │   │   ├───cjs
    │   │   │   │   └───src
    │   │   │   │       └───data
    │   │   │   ├───es6
    │   │   │   │   └───src
    │   │   │   │       └───data
    │   │   │   └───types
    │   │   │       └───src
    │   │   │           └───data
    │   │   └───src
    │   │       └───data
    │   ├───tldts-core
    │   │   ├───dist
    │   │   │   ├───cjs
    │   │   │   │   └───src
    │   │   │   │       └───lookup
    │   │   │   ├───es6
    │   │   │   │   └───src
    │   │   │   │       └───lookup
    │   │   │   └───types
    │   │   │       └───src
    │   │   │           └───lookup
    │   │   └───src
    │   │       └───lookup
    │   ├───to-regex-range
    │   ├───totalist
    │   │   ├───dist
    │   │   └───sync
    │   ├───tough-cookie
    │   │   └───dist
    │   ├───tr46
    │   │   └───lib
    │   ├───ts-api-utils
    │   │   └───lib
    │   ├───ts-interface-checker
    │   │   └───dist
    │   ├───type-check
    │   │   └───lib
    │   ├───typescript
    │   │   ├───bin
    │   │   └───lib
    │   │       ├───cs
    │   │       ├───de
    │   │       ├───es
    │   │       ├───fr
    │   │       ├───it
    │   │       ├───ja
    │   │       ├───ko
    │   │       ├───pl
    │   │       ├───pt-br
    │   │       ├───ru
    │   │       ├───tr
    │   │       ├───zh-cn
    │   │       └───zh-tw
    │   ├───unplugin-utils
    │   │   ├───dist
    │   │   └───node_modules
    │   │       └───picomatch
    │   │           └───lib
    │   ├───update-browserslist-db
    │   ├───uri-js
    │   │   └───dist
    │   │       ├───es5
    │   │       └───esnext
    │   │           └───schemes
    │   ├───util-deprecate
    │   ├───vite
    │   │   ├───bin
    │   │   ├───dist
    │   │   │   ├───client
    │   │   │   └───node
    │   │   │       └───chunks
    │   │   ├───misc
    │   │   ├───node_modules
    │   │   │   ├───fdir
    │   │   │   │   └───dist
    │   │   │   └───picomatch
    │   │   │       └───lib
    │   │   └───types
    │   │       └───internal
    │   ├───vite-dev-rpc
    │   │   └───dist
    │   ├───vite-hot-client
    │   │   └───dist
    │   ├───vite-node
    │   │   └───dist
    │   ├───vite-plugin-inspect
    │   │   ├───dist
    │   │   │   ├───client
    │   │   │   │   └───assets
    │   │   │   │       └───fonts
    │   │   │   └───shared
    │   │   └───node_modules
    │   │       └───perfect-debounce
    │   │           └───dist
    │   ├───vite-plugin-vue-devtools
    │   │   ├───client
    │   │   │   └───assets
    │   │   ├───dist
    │   │   ├───node_modules
    │   │   │   ├───@vue
    │   │   │   │   ├───devtools-kit
    │   │   │   │   │   └───dist
    │   │   │   │   └───devtools-shared
    │   │   │   │       └───dist
    │   │   │   └───perfect-debounce
    │   │   │       └───dist
    │   │   └───src
    │   │       └───overlay
    │   ├───vite-plugin-vue-inspector
    │   │   ├───dist
    │   │   └───src
    │   ├───vitest
    │   │   ├───dist
    │   │   │   ├───chunks
    │   │   │   └───workers
    │   │   └───node_modules
    │   │       └───picomatch
    │   │           └───lib
    │   ├───vue
    │   │   ├───compiler-sfc
    │   │   ├───dist
    │   │   ├───jsx-runtime
    │   │   └───server-renderer
    │   ├───vue-component-type-helpers
    │   ├───vue-eslint-parser
    │   │   └───node_modules
    │   │       └───eslint-visitor-keys
    │   │           ├───dist
    │   │           └───lib
    │   ├───vue-router
    │   │   ├───dist
    │   │   │   └───experimental
    │   │   ├───node_modules
    │   │   │   └───@vue
    │   │   │       └───devtools-api
    │   │   │           └───lib
    │   │   │               ├───cjs
    │   │   │               │   └───api
    │   │   │               └───esm
    │   │   │                   └───api
    │   │   └───vetur
    │   ├───w3c-xmlserializer
    │   │   ├───lib
    │   │   └───node_modules
    │   │       └───xml-name-validator
    │   │           └───lib
    │   ├───webidl-conversions
    │   │   └───lib
    │   ├───whatwg-encoding
    │   │   └───lib
    │   ├───whatwg-mimetype
    │   │   └───lib
    │   ├───whatwg-url
    │   │   └───lib
    │   ├───which
    │   │   └───bin
    │   ├───why-is-node-running
    │   │   └───.github
    │   ├───word-wrap
    │   ├───wrap-ansi
    │   │   └───node_modules
    │   │       └───ansi-styles
    │   ├───wrap-ansi-cjs
    │   │   └───node_modules
    │   │       ├───ansi-regex
    │   │       ├───emoji-regex
    │   │       │   └───es2015
    │   │       ├───string-width
    │   │       └───strip-ansi
    │   ├───ws
    │   │   └───lib
    │   ├───wsl-utils
    │   ├───xml-name-validator
    │   │   └───lib
    │   ├───xmlchars
    │   │   ├───xml
    │   │   │   ├───1.0
    │   │   │   └───1.1
    │   │   └───xmlns
    │   │       └───1.0
    │   ├───yallist
    │   └───yocto-queue
    ├───public
    └───src
        ├───api
        ├───router
        ├───stores
        ├───views
        └───__tests__
---

##  Features

-  Manage people and group expenses
-  Automatically calculate individual shares and balances
-  View detailed balance reports
-  Secure login with validation
-  Real-time updates (through REST endpoints)
-  Unit tests for both frontend and backend

---

##  Tech Stack

**Frontend:**
- Vue.js 3
- Vite
- Axios
- Jest (unit testing)

**Backend:**
- Spring Boot
- Spring Data JPA
- H2 / MySQL (configurable)
- Maven
- JUnit 5 (unit testing)

---

##  How to Run the Project

###  Backend Setup

1. Navigate to the backend folder:
   cd backend

2. Build and run the Spring Boot app:
   mvn spring-boot:run

3. Backend will start on:
   http://localhost:8080

---

###  Frontend Setup

1. Navigate to the frontend folder:
   cd frontend

2. Install dependencies:
   npm install

3. Start the development server:
   npm run dev

4. Frontend runs on:
   http://localhost:5173

---

##  Running Tests

### Backend Tests:
cd backend
mvn test

### Frontend Tests:
cd frontend
npm run test

---

##  License

This project is for academic and learning purposes.
You may modify or extend it freely with proper attribution.
