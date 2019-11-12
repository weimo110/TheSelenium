# coding: utf-8

import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders

mail_host = 'smtp.163.com'
receivers = ['790643111@qq.com']
receiver = ';'.join(receivers)
sender = 'weimoup@163.com'
password = 'weimo110'

msg = MIMEMultipart('alternative')
msg['From'] = sender
msg['To'] = receiver
msg['Subject'] = '主题'

msg.attach(
    MIMEText(
        '<html><body><h1>Hello</h1>' + '<p><img src="cid:0"></p>' +
        '</body></html>', 'html', 'utf-8'))

file_path = r'D:\Test.jpg'
with open(file_path, 'rb') as f:
    mm = MIMEBase('image', 'jpg', filename='b.jpg')
    mm.add_header('Content-Disposition', 'attachment', filename='b.jpg')
    mm.add_header('Content-ID', '<0>')
    mm.add_header('X-Attachment-Id', '0')
    mm.set_payload(f.read())
    encoders.encode_base64(mm)
    msg.attach(mm)

try:
    server = smtplib.SMTP()
    # 加上这句就可以打印出所有的log，更方便我们定位问题
    server.set_debuglevel(1)
    server.connect(mail_host, 25)
    server.login(sender, password)
    server.sendmail(sender, receiver, msg.as_string())
    server.close()
    print('发送成功')
except smtplib.SMTPException:
    print('发送失败')
    