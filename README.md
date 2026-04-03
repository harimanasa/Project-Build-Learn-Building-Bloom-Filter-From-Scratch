# Bloom Filters: Build from Scratch and Learn

## Overview
This project demonstrates the implementation of Bloom filters from scratch, providing a comprehensive understanding of their theory, practical applications, and memory efficiency. The implementation is available in both Python and Java.

## Features
- **Probabilistic Data Structure**: Efficiently checks membership with a small memory footprint.
- **Customizable Parameters**: Adjust false positive rates and memory usage.
- **Multi-language Support**: Implementations in Python and Java.
- **Comprehensive Guide**: Includes theory, formulas, examples, and real-world applications.

## File Structure
```
openspec/
├── changes/
│   ├── build-bloomfilters-from-scratch-and-learn/
│   │   ├── BloomFilterGuide.md  # Comprehensive guide to Bloom filters
│   │   ├── BloomFilter.py       # Python implementation
│   │   ├── BloomFilter.java     # Java implementation
│   │   └── README.md            # Project overview (this file)
│   └── archive/                 # Archived changes
├── specs/                       # Specifications for the project
└── config.yaml                  # Configuration file
```

## Usage
### Python
1. Navigate to the project directory:
   ```bash
   cd openspec/changes/build-bloomfilters-from-scratch-and-learn
   ```
2. Run the Python implementation:
   ```bash
   python BloomFilter.py
   ```

### Java
1. Compile the Java file:
   ```bash
   javac BloomFilter.java
   ```
2. Run the Java implementation:
   ```bash
   java BloomFilter
   ```

## Practical Applications
- **Web Caching**: Quickly check if a URL is cached.
- **Database Queries**: Test if a record exists before querying.
- **Blockchain**: Verify transactions efficiently.
- **Spell Checkers**: Identify potential misspellings.

## Memory Efficiency
Bloom filters are highly memory-efficient, as detailed in the [BloomFilterGuide.md](BloomFilterGuide.md). For example, a dataset requiring 100GB can be represented in just 1.2GB with a 1% false positive rate.

## Memory Efficiency of Bloom Filters

One of the key advantages of Bloom filters is their **memory efficiency**. They allow you to represent large datasets in a compact form, significantly reducing memory usage while enabling fast membership testing.

### Example: Managing a 100GB Dataset
- **Original Dataset**:
  - Suppose you have a dataset of words that takes up 100GB of memory.
  - Each word is stored in its entirety, consuming significant space.

- **Bloom Filter Representation**:
  - Instead of storing the words, a Bloom filter uses a bit array and hash functions to represent the dataset.
  - For example, to store 1 billion words with a 1% false positive rate:
    - **Bit Array Size (`m`)**: Using the formula:
      $$
m = -\frac{n \cdot \ln(p)}{(\ln(2))^2}
      $$
      For $n = 1,000,000,000$ (1 billion words) and $p = 0.01$ (1% false positive rate):
      $$
m \approx 9.58 \times 10^9 \text{ bits} \approx 1.2 \text{ GB}
      $$
    - **Hash Functions (`k`)**: Using the formula:
      $$
k = \frac{m}{n} \cdot \ln(2)
      $$
      For $m = 9.58 \times 10^9$ and $n = 1,000,000,000$:
      $$
k \approx 7
      $$

- **Memory Savings**:
  - Instead of storing 100GB of words, the Bloom filter uses only **1.2GB** of memory.
  - This is a significant reduction, making it feasible to handle large datasets in memory-constrained environments.

### Trade-offs
- **False Positives**:
  - The Bloom filter may indicate that a word is in the set when it is not (1% false positive rate in this example).
- **No Deletions**:
  - Once a word is added, it cannot be removed without affecting other elements.

---

## Acknowledgments
This project was developed using the OpenSpec methodology to ensure a structured and efficient workflow.
