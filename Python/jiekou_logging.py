# https://mp.weixin.qq.com/s?__biz=MzU5NzAyMzcwMA==&mid=2247483820&idx=1&sn=ee3f023e0e7504ed0aa282d5ad64b9ba&chksm=fe588f17c92f06014e1efd56e2b8c19890bfae3af1040f21f27dd58d4af446f05010e67dd6d0&scene=21#wechat_redirect

import logging

# 打印到屏幕
# logging.warn("this logging warn")
# logging.info("this is logging info")

# 打印到指定文件
# LOG_FILENAME = "D:\\log.txt"
# logging.basicConfig(filename=LOG_FILENAME, level=logging.INFO)
# logging.info("This message should go to the log file")

# 通过logging.basicConfig函数对日志的输出格式及方式做相关配置
# LOG_FILENAME = r"D:\log.txt"
# logging.basicConfig(filename=LOG_FILENAME, level=logging.INFO)
# logging.basicConfig(
#     level=logging.DEBUG,
#     format=
#     '%(asctime)s %(filename)s[line:%(lineno)d]  %(levelname)s %(message)s',
#     datefmt='%a, %d %b %Y %H:%M:%S',
#     filename='logs.log',
#     filemode='w')
# logging.debug('debug information')
# logging.info('info information')
# logging.warning('warning information')

# 将日志同时输出到文件和屏幕
LOG_FILENAME = r"D:\log.txt"
logging.basicConfig(filename=LOG_FILENAME, level=logging.INFO)
logging.basicConfig(
    level=logging.DEBUG,
    format=
    '%(asctime)s %(filename)s[line:%(lineno)d]  %(levelname)s %(message)s',
    datefmt='%a, %d %b %Y %H:%M:%S',
    filename='logs.log',
    filemode='w')

# 定义一个StreamHandler，将INFO级别或更高的日志信息打印到标准错误，并将其添加到当前的日志处理对象
console = logging.StreamHandler()
console.setLevel(logging.INFO)
formatter = logging.Formatter('%(name)-12s:%(levelname)-8s %(message)s')
console.setFormatter(formatter)
logging.getLogger('').addHandler(console)

logging.debug('debug information')
logging.info('info information')
logging.warning('warning information')
