# div类型的 https://mp.weixin.qq.com/s/dBwBt2Dyud4pIBe5fqhQNQ
from selenium import webdriver
from time import sleep

driver = webdriver.Chrome()
driver.get("https://www.cnblogs.com")

driver.find_element_by_xpath(".//*[@id='span_userinfo']/a[1]").click()
sleep(3)
driver.find_element_by_id("LoginName").send_keys("790643111@qq.com")
driver.find_element_by_id("Password").send_keys(".ws790643111")
driver.find_element_by_xpath(".//*[@id='submitBtn']/span[1]").click()
driver.add_cookie({'name': '.CNBlogsCookie',
                  'value': 'F956F323DFA5C31BE489C0730C7D891',
                  'domain': '.cnblogs.com'})
driver.add_cookie({'name': '.Cnblogs.AspNetCore.Cookies',
                  'value': 'CfDJ8NJxdyN1379Ivw',
                  'domain': '.cnblogs.com'})
sleep(2)
driver.refresh()
driver.find_element_by_xpath(".//*[@id='span_userinfo']/a[1]").click()
driver.find_element_by_xpath(".//*[@id='avatar_opt_nav']/li[1]/a").click()
sleep(2)
# 文件的路径
file = r"D:\Test.jpg"
# 上传文件
driver.find_element_by_xpath(".//*[@id='jquery-wrapped-fine-uploader']/div/div/input").send_keys(file)
sleep(3)
driver.find_element_by_xpath(".//*[@id='crop_operation_submit']").click()
