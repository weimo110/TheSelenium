# coding: utf-8

import unittest
import time


class MyTest(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        print("SetUp")
        time.sleep(2)

    @classmethod
    def tearDownClass(cls):
        print("teardown")
        time.sleep(2)

    def test01(self):
        print("test01")

    def test03(self):
        print("test03")

    def test02(self):
        print("test02")


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(MyTest)
    unittest.TextTestRunner(verbosity=2).run(suite)
