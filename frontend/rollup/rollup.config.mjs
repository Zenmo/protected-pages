
/**
 * @type {import('rollup').RollupOptions}
 */
export default {
    input: "../../build/js/packages/protectedpages-frontend/kotlin/protectedpages-frontend/energy/lux/protectedpages/frontend/Main.export.mjs",
    //input: "../../build/js/packages/protectedpages-frontend/kotlin/index.html",
    output: {
        dir: "../../jsserver/src/main/resources",
        format: "module",
        entryFileNames: "[name].mjs",
        chunkFileNames: "[name]-[hash].mjs",
    },
    preserveEntrySignatures: "allow-extension",
    //plugins: [html()]
};
