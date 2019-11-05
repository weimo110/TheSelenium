# unittest ��Ԫ���Կ��
unittest�Ѿ���ΪPython�ı�׼��ģ�鷢�������ǰ�װ��Python�Ժ󣬱����ֱ��ʹ��unittest  

### **ʹ��unittest**
- ����unittestģ��
- �̳�unittest.TestCase����
- ���Է�����test��ͷ 

�����������ƽ���ʶ��ķ�ʽ����Ҫ�����������̶����ֵķ�����
- setUp()����ÿ�����Է�������ǰ��ִ�С��ǲ���ǰ��������
- tearDown()����ÿ�����Է������к�ִ�У��ǲ������������
```
import unittest
 
## ���������,����̳�unittest.TestCase����
class DemoTests(unittest.TestCase):
 
    ## ʹ��'@'���η���ע���÷�������ķ���
    ## setUpClass��������ִ�в���֮ǰ��Ҫ�ȵ��õķ���
    @classmethod
    def setUpClass(cls):
        print("call setUpClass()")
    
    ## ÿһ�����Կ�ʼǰ��Ԥ������
    def setUp(self):
        print("call setUp()")
        
    ## ÿһ�����Խ����Ժ��������
    def tearDown(self):
        print("call tearDown()")
 
    ## ����һ�������test��ͷ��
    def test_01(self):
        print("call test_01()")
        pass
 
    ## �������������test��ͷ��
    def test_02(self):
        print("call test_02()")
        pass
 
    ## �������������test��ͷ��
    def test_03(self):
        print("call test_03()")
        pass
 
    ## tearDownClass������ִ�������в��Ժ���õķ���
    ## �ǲ��Խ�������������
    @classmethod
    def tearDownClass(cls):
        print("call tearDownClass()")
 
# ִ�в���������
if __name__ == '__main__':
    ## ִ��mainȫ�ַ���������ִ������������test��ͷ�Ĳ��Է���
    unittest.main(verbosity=2)
```
## unittest �Ķ�������ʹ��
unittest �Ķ��ԣ����� TestCase�ֻ࣬Ҫ�̳��˸��࣬������ͨ�� self���ö���
<table><thead><tr><th>���� Method</th>
	<th>�������</th>
</tr></thead><tbody><tr><td><code>assertEqual(a, b [, msg])</code></td>
	<td>a == b��msg��ѡ����������ʧ�ܵ�ԭ��</td>
</tr><tr><td><code>assertNotEqual(a, b [, msg]</code></td>
	<td>a != b��msg��ѡ����������ʧ�ܵ�ԭ��</td>
</tr><tr><td><code>assertTrue(x [, msg])</code></td>
	<td>x ���棬msg��ѡ����������ʧ�ܵ�ԭ��</td>
</tr><tr><td><code>assertFalse(x [, msg])</code></td>
	<td>x �Ǽ٣�msg��ѡ����������ʧ�ܵ�ԭ��</td>
</tr><tr><td><code>assertIsNot(a, b [, msg])</code></td>
	<td>a ���� b��msg��ѡ����������ʧ�ܵ�ԭ��</td>
</tr></tbody></table>  

### ��װ
**��װ_locate_element()�ļ��ַ���**
- �ҵ�һ��ָ�������(selector)����������ָ�����ַ�(text)  
type(selector, text)
```
def type(self, selector, text):
    """
    Operation input box.
    Usage:
    driver.type("i,el","selenium")
    """
    el = self._locate_element(selector)
    el.clear()
    el.send_keys(text)
```
- �ҵ�һ�����Ե����Ԫ��(selector)�����ҵ��(click)  
click(selector)
```
def click(self, selector):
    """
    It can click any text / image can be clicked
    Connection, check box, radio buttons, and even drop-down box etc..
    Usage:
    driver.click("i,el")
    """
    el = self._locate_element(selector)
    el.click()
```
- �ҵ�һ��ָ����frame�������л���ȥ  
switch_to_frame(selector)
```
def switch_to_frame(self, selector):
    """
    Switch to the specified frame.
    Usage:
    driver.switch_to_frame("i,el")
    """
    el = self._locate_element(selector)
    self.base_driver.switch_to.frame(el)
```
- �ҵ�һ��ָ����select������ͨ��index����ѡ��  
select_by_index(selector, index)
```
def select_by_index(self, selector, index):
    """
    It can click any text / image can be clicked
    Connection, check box, radio buttons, and even drop-down box etc..
    Usage:
    driver.select_by_index("i,el")
    """
    el = self._locate_element(selector)
    Select(el).select_by_index(index)
```
**_locate_element(selector)�ķ�װ��ʽ**  
- ʵ���� ��װ�õ����ʱ����ҪԼ������ʲô�������  
- ǿ������Ӳ���� hard code��ʵ���������� , ���� ? ���� �����ǳ����ַ� =>�� ���߹��췽���д��� this.byChar
- Ҫ�Ѳ��ҵ�Ԫ�صķ��ظ����õĵط�������Ҫ�з���ֵ�������� WebElement
```
def _locate_element(self, selector):
    """
    to locate element by selector
    :arg
    selector should be passed by an example with "i,xxx"
    "x,//*[@id='langs']/button"
    :returns
    DOM element
    """
    if self.by_char not in selector:
        return self.base_driver.find_element_by_id(selector)
 
    selector_by = selector.split(self.by_char)[0].strip()
    selector_value = selector.split(self.by_char)[1].strip()
    if selector_by == "i" or selector_by == 'id':
        element = self.base_driver.find_element_by_id(selector_value)
    elif selector_by == "n" or selector_by == 'name':
        element = self.base_driver.find_element_by_name(selector_value)
    elif selector_by == "c" or selector_by == 'class_name':
        element = self.base_driver.find_element_by_class_name(selector_value)
    elif selector_by == "l" or selector_by == 'link_text':
        element = self.base_driver.find_element_by_link_text(selector_value)
    elif selector_by == "p" or selector_by == 'partial_link_text':
        element = self.base_driver.find_element_by_partial_link_text(selector_value)
    elif selector_by == "t" or selector_by == 'tag_name':
        element = self.base_driver.find_element_by_tag_name(selector_value)
    elif selector_by == "x" or selector_by == 'xpath':
        element = self.base_driver.find_element_by_xpath(selector_value)
    elif selector_by == "s" or selector_by == 'css_selector':
        element = self.base_driver.find_element_by_css_selector(selector_value)
    else:
        raise NameError("Please enter a valid type of targeting elements.")
 
    return element
```
- ��װ��ķ����ĵ���
<table><thead><tr><th>����</th>
	<th>ʾ��(�ָ����Զ���<code>,</code>Ϊ��)</th>
	<th>����</th>
</tr></thead><tbody><tr><td>id</td>
	<td>"account" ���� "i,account" ���� "id,account"</td>
	<td>�ָ����������಻���Կո�</td>
</tr><tr><td>xpath</td>
	<td>"x,//*[@id="s-menu-dashboard"]/button/i"</td>
	<td>&nbsp;</td>
</tr><tr><td>css selector</td>
	<td>"s,#s-menu-dashboard &gt; button &gt; i"</td>
	<td>&nbsp;</td>
</tr><tr><td>link text</td>
	<td>"l,�˳�"</td>
	<td>&nbsp;</td>
</tr><tr><td>partial link text</td>
	<td>"p,��"</td>
	<td>&nbsp;</td>
</tr><tr><td>name</td>
	<td>"n,name1"</td>
	<td>&nbsp;</td>
</tr><tr><td>tag name</td>
	<td>"t,input"</td>
	<td>&nbsp;</td>
</tr><tr><td>class name</td>
	<td>"c,dock-bottom</td>
	<td>&nbsp;</td>
</tr></tbody></table>

```
def login(self, account, password, keep):
    """
    ��¼ϵͳ
    :param account:
    :param password:
    :param keep:
    :return: ���ر��ֵ�¼��ѡ��� checked ֵ
    """
    self.base_driver.type(self.LOGIN_ACCOUNT_SELECTOR, account)
    self.base_driver.type(self.LOGIN_PASSWORD_SELECTOR, password)
 
    current_checked = self.get_current_keep_value()
    if keep:
        if current_checked is None:
            self.base_driver.click(self.LOGIN_KEEP_SELECTOR)
    else:
        if current_checked == "true":
            self.base_driver.click(self.LOGIN_KEEP_SELECTOR)
 
    actual_checked = self.get_current_keep_value()
    self.base_driver.click(self.LOGIN_SUBMIT_SELECTOR)
    sleep(2)
    return actual_checked
```