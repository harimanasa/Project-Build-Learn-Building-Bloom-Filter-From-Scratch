# Spec-Driven Development with OpenSpec

## Overview
This repository demonstrates the use of the OpenSpec methodology for spec-driven development. It includes a variety of projects, each structured to follow a clear workflow from proposal to implementation and documentation.

## Repository Structure
```
openspec/
├── changes/                # Active changes being worked on
│   ├── build-bloomfilters-from-scratch-and-learn/
│   │   ├── BloomFilterGuide.md  # Comprehensive guide to Bloom filters
│   │   ├── BloomFilter.py       # Python implementation
│   │   ├── BloomFilter.java     # Java implementation
│   │   └── README.md            # Project-specific README
│   └── archive/                 # Archived changes
├── specs/                   # Specifications for various projects
├── config.yaml              # Configuration file for OpenSpec
└── Guide.md                 # General guide to using OpenSpec
```

## Getting Started
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the `openspec` directory:
   ```bash
   cd openspec
   ```
3. Explore the projects under `changes/` to see active developments.

## OpenSpec Methodology
OpenSpec is a structured approach to software development that emphasizes:
- **Proposals**: Clearly defining the goals and non-goals of a project.
- **Specifications**: Creating detailed specs to guide implementation.
- **Tasks**: Breaking down work into actionable tasks.
- **Implementation**: Writing code that adheres to the specs.
- **Documentation**: Providing comprehensive guides and READMEs.

## Current Projects
### 1. Build Bloom Filters from Scratch and Learn
- **Description**: A project to implement Bloom filters from scratch, with a focus on learning and understanding their theory, applications, and memory efficiency.
- **Location**: `openspec/changes/build-bloomfilters-from-scratch-and-learn/`
- **Highlights**:
  - Python and Java implementations.
  - Comprehensive guide with examples and use cases.

## Contributing
1. Fork the repository.
2. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Description of changes"
   ```
4. Push to your fork and submit a pull request.

## License
This repository is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgments
Special thanks to the OpenSpec community for providing the tools and methodology to structure this repository.