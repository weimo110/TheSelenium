### ��ʼ����
1. Driver����Python��װĿ¼��
2. import����
```
from selenium import webdriver
from time import sleep
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
```
3. `driver = webdriver.Chrome()`

**������ҳ**  
```
driver.get("http://www.XXX.com")
```
### �ȴ�Ԫ��
1.���Եȴ���implicitly_wait()��: ����ajax�����Ĺ㷺Ӧ�ã�ҳ���Ԫ������������ʱ��ֲ����أ�Ҳ����������ҳ��û�м������ʱ�򣬿���������Ҫ��Ԫ���Ѿ���������ˡ���������ȫ���Եģ��ڿ�ͷ���ù�֮�������ĳ������й����ж�����Ч
```
driver.implicitly_wait(20)
```
2.���Եȴ�
```
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
������
WebDriverWait(driver,20,0.5).until(EC.presence_of_element_located((By.LINK_TEXT, 'CSDN')))
```
3.ǿ�еȴ�����λ�룩
`Thread.sleep(2000);`  
### Ԫ�ض�λ
<table><thead><tr><th>����Method</th>
	<th>����Description</th>
	<th>����Argument</th>
	<th>ʾ��Example</th>
</tr></thead><tbody><tr><td><code>id</code></td>
	<td>�÷���ͨ��ID������ֵȥ��λ���ҵ���Ԫ��</td>
	<td>id: ��Ҫ�����ҵ�Ԫ�ص�ID</td>
	<td><code>find_element_by_id('search')</code></td>
</tr><tr><td><code>name</code></td>
	<td>�÷���ͨ��name������ֵȥ��λ���ҵ���Ԫ��</td>
	<td>name: ��Ҫ�����ҵ�Ԫ�ص�����</td>
	<td><code>find_element_by_name('q')</code></td>
</tr><tr><td><code>class name</code></td>
	<td>�÷���ͨ��class������ֵȥ��λ���ҵ���Ԫ��</td>
	<td>class_name: ��Ҫ�����ҵ�Ԫ�ص�����</td>
	<td><code>find_element_by_class_name('input-text')</code></td>
</tr><tr><td><code>tag_name</code></td>
	<td>�÷���ͨ��tag������ֵȥ��λ���ҵ���Ԫ��</td>
	<td>tag: ��Ҫ�����ҵ�Ԫ�صı�ǩ����</td>
	<td><code>find_element_by_tag_name('input')</code></td>
</tr><tr><td><code>link_text</code></td>
	<td>�÷���ͨ����������ȥ��λ���ҵ���Ԫ��</td>
	<td>link_text: ��Ҫ�����ҵ�Ԫ�ص���������</td>
	<td><code>find_element_by_link_text('Log In')</code></td>
</tr><tr><td><code>partial_link_text</code></td>
	<td>�÷���ͨ��������������ȥ��λ���ҵ���Ԫ��</td>
	<td>link_text: ��Ҫ�����ҵ�Ԫ�صĲ�����������</td>
	<td><code>find_element_by_partial_link_text('Long')</code></td>
</tr><tr><td><code>xpath</code></td>
	<td>�÷���ͨ��XPath��ֵȥ��λ���ҵ���Ԫ��</td>
	<td>xpath: ��Ҫ�����ҵ�Ԫ�ص�xpath</td>
	<td><code>find_element_by_xpath('//*[@id="xx"]/a')</code></td>
</tr><tr><td><code>css_selector</code></td>
	<td>�÷���ͨ��CSSѡ����ȥ��λ���ҵ���Ԫ��</td>
	<td>css_selector: ��Ҫ�����ҵ�Ԫ�ص�ID</td>
	<td><code>find_element_by_css_selector('#search')</code></td>
</tr></tbody></table>
```
# .click()
# .clear()
# .send_keys(Keys.ENTER)
# .send_keys(u"XXX")
# .send_keys(Keys.CONTROL, 'a')
```
**������**  
```
driver.find_element_by_xpath("//option[.='����']").click()
```
**ҳ���ڲ�frame���ü�����**
```
element_frame = driver.find_element_by_css_selector('#iframe-1')
driver.switch_to.frame(element_frame)
����
driver.switch_to.default_content()
```
**����ѡ�����**
```
grou = driver.find_elements_by_class_name("mnav")
len(grou)
driver.find_elements_by_class_name("mnav")[0].click()
```
**xpath**  
![](images/xPath.png)  
**cssSelector** 
1. ���һ�� <a id="customer_chosen">
2. �Զ�������һ�� &lt;ul id="customer_list">
3. ���&lt;ul>�ĵ����&lt;li>
```
driver.find_element_by_css_selector('#customer_chosen').click()
driver.find_element_by_css_selector('#customer_list > li:nth-child(5)')
```
![](images/css_selector.png)
### ���ڲ���    
**��С�趨** 
```
driver.set_window_size(800, 400)
driver.maximize_window()
```
**ǰ������**
```
driver.back()
driver.forward()
```

**����ҳ�沶��**
```
```
**������**
```
alert = driver.switch_to.alert
alert.accept()
alert.dismiss() 
```
### �����̲���
```
context_click() # �һ�
double_click() # ˫��
drag_and_drop() # ��ק
move_to_element() # ���ͣ��һ��Ԫ����
click_and_hold() # ������������һ��Ԫ����
```
**Robot����** ׼ȷģ�������̲���
```

```
**Action�����** ģ����꣬IE��֧��
```
# ����ģ������Ҽ�
from selenium.webdriver.common.action_chains import ActionChains
# ��λ��Ҫ�һ���Ԫ��
right =driver.find_element_by_xpath("xx")
# �Զ�λ����Ԫ��ִ������Ҽ�����
ActionChains(driver).context_click(right).perform()
# ��λ��Ҫ˫����Ԫ��
double = driver.find_element_by_xpath("xxx")
# �Զ�λ����Ԫ��ִ�����˫������
ActionChains(driver).double_click(double).perform()
```
**�����¼�**
        <table><thead><tr><th>����</th>
			<th>����</th>
		</tr></thead><tbody><tr><td><code>send_keys(Keys.BACKSPACE)</code></td>
			<td>ɾ����(BackSpace)</td>
		</tr><tr><td><code>send_keys(Keys.SPACE)</code></td>
			<td>�ո��(Space)</td>
		</tr><tr><td><code>send_keys(Keys.TAB)</code></td>
			<td>�Ʊ��(Tab)</td>
		</tr><tr><td><code>send_keys(Keys.ESCAPE)</code></td>
			<td>���˼�(Esc)</td>
		</tr><tr><td><code>send_keys(Keys.ENTER)</code></td>
			<td>�س���(Enter)</td>
		</tr><tr><td><code>send_keys(Keys.CONTROL,'a')</code></td>
			<td>ȫѡ��Ctrl+A��</td>
		</tr><tr><td><code>send_keys(Keys.CONTROL,'c')</code></td>
			<td>���ƣ�Ctrl+C��</td>
		</tr></tbody></table>
```
```
### ����
**�ر�Chrome�Զ���������ʾ**
```
options.add_experimental_option('prefs', prefs)
options.add_argument("disable-infobars")
```
**��ͼ����**
```
save_screenshot(file)
```
**expected_conditionsģ��**
```
selenium.webdriver.support.expected_conditions
```
1. ��֤title: �Ƿ���ڻ������driver.title 
```
title_is  
title_contains  
```
2. ��֤Ԫ���Ƿ����: ����Ĳ�������Ԫ�����͵�locator
```
presence_of_element_located  
presence_of_all_elements_located  
```
3. ��֤Ԫ���Ƿ�ɼ�
```
visibility_of_element_located  # ����Ԫ�����͵�locator
invisibility_of_element_located  # ����Ԫ�����͵�locator
visibility_of  # ����WebElement
```
4. ĳ���ı��Ƿ������ĳԪ��
```
text_to_be_present_in_element  
text_to_be_present_in_element_value
```
5. �ж�frame�Ƿ������
```
frame_to_be_available_and_switch_to_it 
```
6. �ж��Ƿ���alert����
```
alert_is_present 
```
7. �ж�Ԫ���Ƿ�ɵ��
```
element_to_be_clickable  # ����Ԫ�����͵�locator
```
8. �ж�Ԫ���Ƿ�ѡ��
```
element_to_be_selected  # ����WebElement����
element_located_to_be_selected  # locatorԪ��
element_selection_state_to_be  # ����WebElement�����Լ�״̬(����boolean)
element_located_selection_state_to_be  # ����locator�Լ�״̬(����boolean)
```
9. �ж�һ��Ԫ���Ƿ�����DOM��: ����WebElement���󣬿����ж�ҳ���Ƿ�ˢ����
```
staleness_of 
```