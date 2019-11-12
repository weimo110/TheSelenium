# coding: utf-8

import unittest
from common.module import email_module


def all_case():
    # 你的文件路径
    case_dir = r"D:\3.代码\unittest(kuangjia)"
    discover = unittest.defaultTestLoader.discover(case_dir, pattern="test*.py", top_level_dir=None)

    return discover


if __name__ == '__main__':
    # 导入HTMLTestRunner模块
    import HTMLTestRunner

    # 结尾一定要写.html哦
    report_path = r"D:\3.代码\unittest(kuangjia)\report.html"
    fp = open(report_path, "wb")
    runner = HTMLTestRunner.HTMLTestRunner(stream=fp, title=u"测试报告", description=u"用例执行情况")
    runner.run(all_case())
    fp.close()

    # 调用封装好的sendMail方法，参数为上面的文件
    mail = email_module.sendMail(report_path)
    print("邮件发送成功")
