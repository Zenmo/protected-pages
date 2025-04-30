/**
 * @param {import("../build/js/node_modules/webpack").Configuration} config
 */
function editConfig(config) {
    config.entry = {
        main: require('path').resolve(__dirname, "kotlin/protectedpages-frontend/energy/lux/protectedpages/frontend/Main.export.mjs")
    }

    config.experiments = {
        outputModule: true,
    }
    config.output.library = {
        type: "module"
    }
    config.output.enabledLibraryTypes = ["module"]
    config.output.libraryTarget = "module"
    config.output.chunkFormat = "module"
}

editConfig(config)
