# coding: utf-8

import unittest


class testCases(unittest.TestCase):

    def setUp(self):
        print("setUp")

    def tearDown(self):
        print("tearDown")

    def test01(self):
        print("test01")

    def test03(self):
        print("test03")

    def test02(self):
        print("test02")


# 只有该文件独立运行时执行
if __name__ == '__main__':
    # pass
    # 第一种方法
    # unittest.main()

    # 第二种方法
    # suite = unittest.TestLoader().loadTestsFromTestCase(testCases)
    # unittest.TextTestRunner(verbosity=2).run(suite)

    #  第三种方法：只测23
    # testsuit = unistsuit)ttest.TestSuite()
    #     # testsuit.addTest(testCases("test03"))
    #     # testsuit.addTest(testCases("test02"))
    #     # runner = unittest.TextTestRunner()
    #     # runner.run(te

    # 第四种方法
    test_dir = r"D:\3.代码\unittest(kuangjia)"
    report_dir = r"D:\3.代码\unittest(kuangjia)\report.html"
    test_discover = unittest.defaultTestLoader.discover(test_dir, pattern='test*.py')
    runner = unittest.TextTestRunner()
    runner.run(test_discover)

