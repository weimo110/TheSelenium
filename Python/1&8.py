# coding: utf-8

from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()
driver.get("http://blog.hexun.com/")
driver.find_element_by_id("read_btn").click()
driver.maximize_window()
sleep(3)
# driver.find_element_by_xpath(".//*[@id='hexunMember_nologinSetup_span_display_loginBTN']/a").click()
# sleep(3)
driver.find_element_by_id("username").send_keys("你注册的账号")
driver.find_element_by_id("password").send_keys("你的密码")
driver.find_element_by_xpath(
    ".//*[@id='login12']/div/div/div/div[3]/input").click()
sleep(3)
# 点击发送博客
driver.find_element_by_xpath(".//*[@id='login12']/div/div/div[3]/a[1]").click()
sleep(3)
curr = driver.current_window_handle
all_curr = driver.window_handles
for i in all_curr:
    if i != curr:
        driver.switch_to.window(i)
        sleep(2)
        driver.find_element_by_id("hxjy_blog_tit").send_keys(u"我的文章")

        driver.switch_to.frame(driver.find_element_by_xpath(
            ".//*[@id='editorContainer']/iframe"))
        sleep(2)

        driver.find_element_by_xpath("html/body").click()

        driver.find_element_by_xpath("html/body").send_keys(u"童林")
        driver.switch_to.default_content()
        # 页面下拉
        js = "var q=document.documentElement.scrollTop=1000"
        driver.execute_script(js)
        driver.find_element_by_xpath(
            ".//*[@id='hxjy_blog_label']").send_keys(u"测试")
        driver.find_element_by_xpath(".//*[@id='postarticle']").click()
