rootProject.name = "Fujitsu-backend"
include(
    ":api:api-protocol",
    ":api:api-domain",
    ":api:api-persistence",
)
include(
    "persistence-impl",
    "rest-app"
)