class BloomFilter:
    def __init__(self, size, hash_functions):
        """
        Initialize the Bloom filter.

        :param size: Number of bits in the Bloom filter.
        :param hash_functions: List of hash functions to use.
        """
        self.size = size
        self.bit_array = [0] * size
        self.hash_functions = hash_functions

    def add(self, item):
        """
        Add an item to the Bloom filter.

        :param item: The item to add.
        """
        for hash_function in self.hash_functions:
            index = hash_function(item) % self.size
            self.bit_array[index] = 1

    def contains(self, item):
        """
        Check if an item is in the Bloom filter.

        :param item: The item to check.
        :return: True if the item is probably in the filter, False if it is definitely not.
        """
        for hash_function in self.hash_functions:
            index = hash_function(item) % self.size
            if self.bit_array[index] == 0:
                return False
        return True

# Example usage
if __name__ == "__main__":
    import hashlib

    def hash_fn1(x):
        return int(hashlib.md5(x.encode()).hexdigest(), 16)

    def hash_fn2(x):
        return int(hashlib.sha1(x.encode()).hexdigest(), 16)

    def hash_fn3(x):
        return int(hashlib.sha256(x.encode()).hexdigest(), 16)

    # Create a Bloom filter with 1000 bits and 3 hash functions
    bloom_filter = BloomFilter(1000, [hash_fn1, hash_fn2, hash_fn3])

    # Add items to the Bloom filter
    bloom_filter.add("apple")
    bloom_filter.add("banana")

    # Check membership
    print(bloom_filter.contains("apple"))  # True
    print(bloom_filter.contains("banana"))  # True
    print(bloom_filter.contains("cherry"))  # False