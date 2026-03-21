# Changelog



---
## [Unreleased] - 21.03.2026
### Added
- Implemented business logic
- Exceptions `FeeNotFoundException`,
`MeasurementNotFoundException`, `RestrictedConditionException`
- Mappers `RequestMapper` and `ResponseMapper`
- DTO objects `FeeResult`, `RegionName`, `WmoCode`, `VehicleType` and 
all the CREATE Requests, GET Responses.
- Service interfaces for `ATEF`, `WSEF`, `WPEF`
- Repositories for corresponding entities
- Entity models to store and manage all the data required
- Implemented null safe entity models in api-protocol
- Filled docs(visualization) with Entity Relation Model
- Designed the Entity Relation model
- rest-app
- persistence-impl
- api-protocol
- api-persistence
- api-domain
- MIT license
- Configured root build.gradle for multi-module project
- Added sub-docs: `CHANGELOG.MD`, `VISUALIZATION.MD`, `WORKFLOW.MD`
- Added docs `README.MD`
- First init of project

### Changed
- Added dependency on JetBrains annotations
- Removed RestrictionEntity
- Entity models now has property `isAllowed`
- BaseFeeService, Entity, etc. are renamed to TotalFee
- DTOs are now in api-protocol instead of api-domain
- Entity models now has nullable field ID

### Fixed