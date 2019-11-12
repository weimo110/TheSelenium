# coding: utf-8
from selenium import webdriver
from time import sleep
from selenium.webdriver.common.keys import Keys


driver = webdriver.Chrome()
driver.get("http://www.baidu.com")
# 输入框输入内容
driver.find_element_by_id("kw").send_keys("selenium")
sleep(3)
# 删除多输入的一个 m
driver.find_element_by_id("kw").send_keys(Keys.BACK_SPACE)
sleep(3)
# 继续输入“教程”
driver.find_element_by_id("kw").send_keys("教程")
sleep(3)
# ctrl+a 全选输入框内容
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'a')
sleep(3)
# ctrl+x 剪切输入框内容
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'x')
sleep(3)
# 输入框重新输入内容，搜索
driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'v')
sleep(3)
# 通过回车键盘来代替点击操作
driver.find_element_by_id("su").send_keys(Keys.ENTER)
sleep(3)
driver.quit()
