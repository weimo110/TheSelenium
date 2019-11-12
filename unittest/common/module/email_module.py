# coding: utf-8
import unittest
import sys
from imp import reload

import baseInfo
import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart


# 装饰器
@unittest.skip('先不发邮件')
# reload(sys)
# sys.setdefaultencoding('utf8')
def sendMail(file):
    f = open(file, 'rb')
    # 读取测试报告正文
    mail_body = f.read()
    f.close()

    # 创建一个带附件的实例
    msg = MIMEMultipart()
    msg['From'] = baseInfo.Smtp_Sender
    receiver = ','.join(baseInfo.Smtp_Receivers)
    msg['To'] = receiver
    msg['Subject'] = 'Python test'

    # 邮件正文
    msg.attach(MIMEText('sending email test', 'plain', 'utf-8'))

    # 构造附件
    att1 = MIMEText(mail_body, 'base64', 'utf-8')
    att1['Content-Type'] = 'application/octet-stream'
    att1['Content-Disposition'] = 'attachment; filename= %s' % file
    msg.attach(att1)

    try:
        smtpObj = smtplib.SMTP()
        smtpObj.connect(baseInfo.mail_host, 25)
        smtpObj.login(baseInfo.Smtp_Sender, baseInfo.Smtp_Password)
        smtpObj.sendmail(baseInfo.Smtp_Sender, receiver, msg.as_string())
        print('发送成功')
    except smtplib.SMTPException:
        print('发送失败')
