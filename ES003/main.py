from ES003 import ES003
import unittest

class TestES003Methods(unittest.TestCase):
    def test_es003(self):
        es = ES003(1)
        response = es.compute()
        expectedResponse =[[1], [0.5, 0.5], [0.2, 0.2, 0.2, 0.2, 0.2]]
        self.assertEqual(expectedResponse, response)

if __name__ == '__main__':
    unittest.main() 