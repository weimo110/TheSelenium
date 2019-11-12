# coding: utf-8

import xlrd

# excel路径
excel_path = r'D:\Test.xlsx'

# 打开Excel
data = xlrd.open_workbook(excel_path)

# 查看Excel中的sheet名称
data.sheet_names()
# 通过索引或表名获取第一个工作表：一个list
table = data.sheets()[0]
table1 = data.sheet_by_index(0)
table2 = data.sheet_by_name(u'部门管理')
print(table, table1, table2)
# 获取行数和列数
nrows = table.nrows
ncols = table.ncols
print(nrows, ncols)
# 获取整行和整列的值
# print(table.row_values(1))
# print(table.col_values(2))
# 循环行，得到索引的列表
for rn in range(table.nrows):
    print(table.row_values(rn))

# 单元格
cell_A1 = table.cell(0, 0).value
cell_A2 = table.cell(1, 0).value
# print cell_A1, cell_A2

# 分别使用行列索引
cell_A3 = table.row(0)[0].value
cell_A4 = table.col(1)[1].value
# print(cell_A3, cell_A4)
