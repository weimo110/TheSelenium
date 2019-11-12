# coding: utf-8
from selenium import webdriver

driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
driver.maximize_window()
grou = driver.find_elements_by_class_name("mnav")
# 查看该组对象的长度
len(grou)
# 点击新闻按钮
driver.find_elements_by_class_name("mnav")[0].click()