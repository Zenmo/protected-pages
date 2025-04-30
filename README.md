# Protected pages

This is a proof of concept of a Kotlin/JS single page application where some of
the javascript is not publicly accessible.

The module [shared](./shared) defines an object `AccessPolicy` which
specifies under which condition the user may access the page.

The module [frontend](./frontend) contains the SPA.

The module [jsserver](./jsserver) has a custom fileserver.
