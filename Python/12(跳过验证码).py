# coding: utf-8
# 需fiddler寻找cookies

from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()
driver.get("https://www.cnblogs.com/")
driver.add_cookie({'name': '.CNBlogsCookie',
                   'value': '45E821B8C9CB67088674479A3C874E',
                   'domain': '.cnblogs.com'})
driver.add_cookie({'name': '.Cnblogs.AspNetCore.Cookies',
                   'value': 'CfDJ8N7AeFYNSk1Put6Iydpme28w5Q',
                   'domain': '.cnblogs.com'})
sleep(2)

driver.refresh()
