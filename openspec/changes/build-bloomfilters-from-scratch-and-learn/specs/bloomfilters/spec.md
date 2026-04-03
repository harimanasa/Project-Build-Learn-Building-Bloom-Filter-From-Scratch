## ADDED Requirements

### Requirement: Implement Bloom Filter
The system SHALL implement a Bloom filter for efficient membership testing.

#### Scenario: Add an element to the Bloom filter
- **WHEN** an element is added to the Bloom filter
- **THEN** the corresponding bits SHALL be set in the bit array using hash functions.

#### Scenario: Check membership of an element
- **WHEN** an element is checked for membership
- **THEN** the system SHALL return true if all corresponding bits are set, otherwise false.

#### Scenario: False positives
- **WHEN** an element not in the set is checked
- **THEN** the system MAY return true due to hash collisions, but SHALL NOT return false for elements in the set.