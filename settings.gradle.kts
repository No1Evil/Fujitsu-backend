rootProject.name = "Fujitsu-backend"
/** API */
include(
    ":api:api-protocol",
    ":api:api-domain",
    ":api:api-persistence",
)

/** Implementations */
include(
    ":implementations:persistence-impl",
    ":implementations:business-logic"
)

/** Application */
include(
    "rest-app"
)