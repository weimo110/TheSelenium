# coding: utf-8

from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()
driver.get("https://www.baidu.com")

# 设置浏览器宽800，高400
driver.set_window_size(800, 400)

sleep(3)

# 最大化窗口
driver.maximize_window()

driver.get("https://www.cnblogs.com/")
sleep(3)

# 后退到上一个页面
driver.back()

sleep(3)

# 前进到下一个页面
driver.forward()

sleep(3)
