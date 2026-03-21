rootProject.name = "Fujitsu-backend"
include("persistence-impl")
include("api-protocol")
include("api-domain")
include("api-persistence")
include("rest-app")
include(
    ":api:api-protocol",
    ":api:api-domain",
    ":api:api-persistence",
)