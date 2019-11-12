# coding: utf-8

import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

sender = 'weimoup@163.com'
passwd = 'weimo110'
receivers = ['790643111@qq.com']
receiver = ';'.join(receivers)
mail_host = 'smtp.163.com'

msg = MIMEMultipart()
msg['From'] = sender
msg['To'] = receiver
msg['Subject'] = 'Python test'
# 邮件正文
msg.attach(MIMEText('sending email test', 'plain', 'utf-8'))
# 构造附件1
att1 = MIMEText(open('D:\\Test.txt', 'rb').read(), 'base64', 'utf-8')
att1['Content-Type'] = 'application/octet-stream'
att1['Content-Disposition'] = 'attachment; filename= "Test.txt"'
msg.attach(att1)
# 构造附件
# att2 = MIMEText(open('D:\\Test.jpg').read(), 'base64', 'utf-8')
# att2['Content-Type'] = 'application/octet-stream'
# att2['Content-Disposition'] = 'attachment; filename="b.txt"'
# msg.attach(att2)

try:
    smtpObj = smtplib.SMTP()
    smtpObj.connect(mail_host, 25)
    smtpObj.login(sender, passwd)
    smtpObj.sendmail(sender, receivers, msg.as_string())
    print('发送成功')
except smtplib.SMTPException:
    print('发送失败')
    