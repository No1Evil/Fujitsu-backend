rootProject.name = "Fujitsu-backend"
/** API */
include(
    ":api:api-protocol",
    ":api:api-domain",
    ":api:api-persistence",
)
include(
    "persistence-impl",
    ":implementations:persistence-impl",
    ":implementations:business-logic"
    "rest-app"
)