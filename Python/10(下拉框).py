# coding: utf-8

from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from time import sleep

# 去掉"Chrome正受到自动测试软件的控制。"
options = webdriver.ChromeOptions()
options.add_argument('disable-infobars')
driver = webdriver.Chrome(chrome_options=options)
driver.get("https://www.baidu.com/")
# 鼠标移动到设置
ActionChains(driver).move_to_element(
    driver.find_element_by_xpath(".//*[@id='u1']/a[8]")).perform()
sleep(2)
driver.find_element_by_xpath(".//*[@id='wrapper']/div[6]/a[1]").click()
sleep(2)
# 修改每页显示条数--1、定位到下拉框
driver.find_element_by_xpath(".//*[@id='nr']").click()
# 点击下拉框选项
driver.find_element_by_xpath("//option[.='每页显示20条']").click()
sleep(2)
# 点击保存设置
driver.find_element_by_xpath(".//*[@id='gxszButton']/a[1]").click()
sleep(2)
alert = driver.switch_to.alert
# print alert.text
alert.accept()
# alert.dismiss() 取消