# 20. unittest是展开自动化测试的基础   https://mp.weixin.qq.com/s/eopuYeTWMTYPDU52aJ7CCA
# 21. selenium框架   https://mp.weixin.qq.com/s/Iyi3dI9tsYuwvAf6FeAPvw

from selenium import webdriver
from time import sleep
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
driver.get("http://demo.ranzhi.org/sys/index.php?m=user&f=login")
driver.maximize_window()
driver.find_element_by_id("account").clear()
driver.find_element_by_id("account").send_keys("demo")
driver.find_element_by_id("password").clear()
driver.find_element_by_id("password").send_keys("demo")
driver.find_element_by_id("submit").click()
element = driver.find_elements_by_class_name("navbar-nav")
ActionChains(driver).move_to_element(element).perform()
element = driver.find_element_by_css_selector("body")
actions = ActionChains(driver)
driver.find_elements_by_link_text("编辑信息").click()

