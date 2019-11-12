# coding: utf-8

import unittest
import time
import ddt

info = [{"username": "captain", "password": 123},
        {"username": "warrior", "password": 456}]


@ddt.ddt
class MyTest(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        print("SetUp")
        time.sleep(2)

    @classmethod
    def tearDownClass(cls):
        print("teardown")
        time.sleep(2)

    @ddt.data(*info)
    def test01(self, mes):
        print(mes)

    @ddt.data(*info)
    def test03(self, res):
        print(res["username"])

    def test02(self):
        print("test02")


if __name__ == '__main__':
    unittest.main()
