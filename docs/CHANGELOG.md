# Changelog

--- [Unreleased] - 26.03.2026
- Applied Google code style to module: persistence-impl

--- [Unreleased] - 25.03.2026
- Applied Google code style to modules:
  - api-protocol
  - api-persistence
  - api-protocol
  - business-logic

---
## [Unreleased] - 22.03.2026 - 23.03.2026
- Done a lot of work on DRY principle, made sure
that there is no overloaded DRY so that the system stays modular.
- Implemented DTO objects:
  - Request
    - Fees related
      - CreateAirTemperatureFee
      - CreateRegionalBasedFee
      - CreateWeatherPhenomenonFee
      - CreateWindSpeedFee
      - GetAirTemperatureFee
      - GetRegionalBasedFee
      - GetWeatherPhenomenonFee
      - GetWindSpeedFee
      - GetTotalFee
    - Objects related:
      - CreateVehicleType
      - CreateRegion
      - CreateMeasurement
      - GetMeasurement
  - Response
    - Fees related
      - AirTemperatureFee
      - RegionalBasedFee
      - WeatherPhenomenonFee
      - WindSpeedFee
      - TotalFee
    - Objects related
      - VehicleType
      - Region
      - Measurement
- Implemented services:
  - Fee related:
    - AirTemperatureFeeService
    - RegionalBasedFeeService
    - TotalFeeService
    - WeatherPhenomenonFeeService
    - WindSpeedFeeService
  - Base entities related:
    - MeasurementService
    - RegionService
    - VehicleTypeService
- Implemented DAO (Using JDBC):
  - Fee related
    - JdbcAirTemperatureFee
    - JdbcRegionalBasedFee
    - JdbcWeatherPhenomenonFee
    - JdbcWindSpeedFee
  - Base entities related:
    - JdbcMeasurement
    - JdbcRegion
    - JdbcVehicleType
- Implement BaseFeeService with returning FeeResult method getBaseFee(request) to unify fees under one contract.
- Implemented schema.sql scripts for finding fees.
- Implemented some Dao objects, mappers for requests to entity and reversed.
- Implemented SqlConstants to simplify writing basic scripts.
- Implementation of persistence-api in persistence-impl.

## Changes
- Instead of using VehicleType in requests switched to vehicleTypeId
- Switched from VehicleType enum to VehicleType record.
- Removed unnecessary sealed parameter in interface. (thought that'd be cool)
- Some RegionalBasedFee classes had names RegionalBaseFee.
- Changed entity relation model visualization.

## Plans
- Create DTO for weatherPhenomenon instead of raw string
- Create DTO for all Entity ids
- Rename fields in WindSpeedFee... to *_speed instead of *_wind_speed
- **Tests for persistence-impl and business-logic**
- Implement OpenAPI Swagger into rest-app
- REST API Controller application implementation
- Docker

---
## [Unreleased] - 21.03.2026
### Added
- Implemented business logic.
- Exceptions `FeeNotFoundException`,
`MeasurementNotFoundException`, `RestrictedConditionException`
- Mappers `RequestMapper` and `ResponseMapper`
- DTO objects `FeeResult`, `RegionName`, `WmoCode`, `VehicleType` and 
all the CREATE Requests, GET Responses.
- Service interfaces for `ATEF`, `WSEF`, `WPEF`.
- Repositories for corresponding entities.
- Entity models to store and manage all the data required.
- Implemented null safe entity models in api-protocol.
- Filled docs(visualization) with Entity Relation Model.
- Designed the Entity Relation model.
- rest-app.
- persistence-impl.
- api-protocol.
- api-persistence.
- api-domain.
- MIT license.
- Configured root build.gradle for multi-module project.
- Added sub-docs: `CHANGELOG.MD`, `VISUALIZATION.MD`, `WORKFLOW.MD`.
- Added docs `README.MD`.
- First init of project.

### Changed
- Added dependency on JetBrains annotations.
- Removed RestrictionEntity.
- Entity models now has property `isAllowed`.
- BaseFeeService, Entity, etc. are renamed to TotalFee.
- DTOs are now in api-protocol instead of api-domain.
- Entity models now has nullable field ID.

### Fixed