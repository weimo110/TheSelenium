# coding=utf-8
# https://mp.weixin.qq.com/s/lD8jBS0nNz6LA2MH2TLEbQ
# robot Framework了吧，那个就是关键字驱动，“关键字”其实就是把函数封装成关键字，用的时候直接把这个封装好的关键字拿过来用就OK了
from time import sleep
from selenium import webdriver

driver = webdriver.Chrome()
driver.maximize_window()
driver.implicitly_wait(6)
driver.get("https://tieba.baidu.com/index.html")
sleep(1)
# 用目标元素参考去拖动
target_elem = driver.find_element_by_link_text("地区")
js= 'arguments[0].scrollIntoView();'
driver.execute_script(js, target_elem)
# 弹出框
driver.execute_script("window.alert('弹出框');")
sleep(2)
driver.switch_to.alert.accept()
sleep(2)
# 拉到页面顶部
js1 = 'document.documentElement.scrollTop=0'
driver.execute_script(js1)
sleep(2)
# 拉到页面底部
js2 = 'document.documentElement.scrollTop=10000'
driver.execute_script(js2)