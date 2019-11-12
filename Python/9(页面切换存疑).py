# coding: utf-8

from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()
driver.get("http://www.jrj.com.cn/")
driver.find_element_by_xpath("html/body/div[11]/div[1]/div/div[1]/p/a[5]").click()
current_handle = driver.current_window_handle
all_handles = driver.window_handles
for i in all_handles:
    if current_handle != i:
        driver.switch_to.window(i)
        sleep(2)
        driver.find_element_by_xpath("html/body/div[10]/div[1]/div/dl/dt[1]/div[1]/p/a[2]").click()