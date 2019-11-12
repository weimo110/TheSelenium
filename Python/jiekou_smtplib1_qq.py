# coding=utf-8

import smtplib
from email.mime.text import MIMEText

mail_host = 'smtp.qq.com'
receivers = 'weimoup@163.com'
sender = '790643111@qq.com'
receiver = ';'.join(receivers)
passwd = 'vfckzbowdycsbahi'
contents = 'Python 发送邮件'
# 构造邮件正文
msg = MIMEText(contents, 'plain', 'utf-8')
# 构造邮件头部
msg['From'] = sender
msg['To'] = receiver
msg['Subject'] = '主题'
try:
    server = smtplib.SMTP_SSL(mail_host, 465)
    server.login(sender, passwd)
    server.sendmail(sender, receivers, msg.as_string())
    print("发送成功")
except smtplib.SMTPException:
    print("无法发送")
    