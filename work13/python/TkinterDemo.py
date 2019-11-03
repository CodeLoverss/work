from tkinter import *
import tkinter.messagebox
#window=tkinter.Tk()
#设置tkinter窗口
root = Tk()
root.title('TkinterDemo')
root.geometry('400x400')
Label(root,text="请输入：")
#导入两个输入框
e1 = Entry(root)
#设置输入框的位置
e1.grid(row =0 ,column =0)
#输入内容获取函数print打印
def show():
    tkinter.messagebox.askquestion(title='hi', message='你输入了'+e1.get())
#设置两个按钮，点击按钮执行命令 command= 命令函数
theButton1 = Button(root, text ="获取内容", width =10,command =show)
#设置按钮的位置行列及大小
theButton1.grid(row =1 ,column =0,sticky =W, padx=10,pady =5)
mainloop()