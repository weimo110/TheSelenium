# unittest 单元测试框架
unittest已经作为Python的标准库模块发布。我们安装完Python以后，便可以直接使用unittest  

### **使用unittest**
- 引入unittest模组
- 继承unittest.TestCase基类
- 测试方法以test开头 

依靠方法名称进行识别的方式。主要有以下两个固定名字的方法：
- setUp()：在每个测试方法运行前，执行。是测试前置条件。
- tearDown()：在每个测试方法运行后执行，是测试清理操作。
```
import unittest
 
## 定义测试类,必须继承unittest.TestCase基类
class DemoTests(unittest.TestCase):
 
    ## 使用'@'修饰符，注明该方法是类的方法
    ## setUpClass方法是在执行测试之前需要先调用的方法
    @classmethod
    def setUpClass(cls):
        print("call setUpClass()")
    
    ## 每一个测试开始前的预置条件
    def setUp(self):
        print("call setUp()")
        
    ## 每一个测试结束以后的清理工作
    def tearDown(self):
        print("call tearDown()")
 
    ## 测试一（务必以test开头）
    def test_01(self):
        print("call test_01()")
        pass
 
    ## 测试三（务必以test开头）
    def test_02(self):
        print("call test_02()")
        pass
 
    ## 测试三（务必以test开头）
    def test_03(self):
        print("call test_03()")
        pass
 
    ## tearDownClass方法是执行完所有测试后调用的方法
    ## 是测试结束后的清除工作
    @classmethod
    def tearDownClass(cls):
        print("call tearDownClass()")
 
# 执行测试主函数
if __name__ == '__main__':
    ## 执行main全局方法，将会执行上述所有以test开头的测试方法
    unittest.main(verbosity=2)
```
## unittest 的断言配置使用
unittest 的断言，属于 TestCase类，只要继承了该类，均可以通过 self调用断言
<table><thead><tr><th>方法 Method</th>
	<th>检查条件</th>
</tr></thead><tbody><tr><td><code>assertEqual(a, b [, msg])</code></td>
	<td>a == b，msg可选，用来解释失败的原因</td>
</tr><tr><td><code>assertNotEqual(a, b [, msg]</code></td>
	<td>a != b，msg可选，用来解释失败的原因</td>
</tr><tr><td><code>assertTrue(x [, msg])</code></td>
	<td>x 是真，msg可选，用来解释失败的原因</td>
</tr><tr><td><code>assertFalse(x [, msg])</code></td>
	<td>x 是假，msg可选，用来解释失败的原因</td>
</tr><tr><td><code>assertIsNot(a, b [, msg])</code></td>
	<td>a 不是 b，msg可选，用来解释失败的原因</td>
</tr></tbody></table>  

### 封装
**封装_locate_element()的几种方法**
- 找到一个指定输入框(selector)，并且输入指定的字符(text)  
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
- 找到一个可以点击的元素(selector)，并且点击(click)  
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
- 找到一个指定的frame，并且切换进去  
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
- 找到一个指定的select，并且通过index进行选择  
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
**_locate_element(selector)的封装方式**  
- 实例化 封装好的类的时候，需要约定好是什么特殊符号  
- 强制性用硬编码 hard code来实例化，例如 , 或者 ? 或者 其他非常用字符 =>， 或者构造方法中传递 this.byChar
- 要把查找到元素的返回给调用的地方：必须要有返回值，类型是 WebElement
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
- 封装后的方法的调用
<table><thead><tr><th>类型</th>
	<th>示例(分隔符以逗号<code>,</code>为例)</th>
	<th>描述</th>
</tr></thead><tbody><tr><td>id</td>
	<td>"account" 或者 "i,account" 或者 "id,account"</td>
	<td>分隔符左右两侧不可以空格</td>
</tr><tr><td>xpath</td>
	<td>"x,//*[@id="s-menu-dashboard"]/button/i"</td>
	<td>&nbsp;</td>
</tr><tr><td>css selector</td>
	<td>"s,#s-menu-dashboard &gt; button &gt; i"</td>
	<td>&nbsp;</td>
</tr><tr><td>link text</td>
	<td>"l,退出"</td>
	<td>&nbsp;</td>
</tr><tr><td>partial link text</td>
	<td>"p,退"</td>
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
    登录系统
    :param account:
    :param password:
    :param keep:
    :return: 返回保持登录复选框的 checked 值
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