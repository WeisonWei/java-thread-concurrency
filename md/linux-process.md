# Linux 进程

1 Linux中进程的七种状态
（1）R运行状态（runing）：并不意味着进程一定在运行中，也可以在运行队列里；
（2）S睡眠状态（sleeping）：进程在等待事件完成；（浅度睡眠，可以被唤醒）
（3）D磁盘睡眠状态（Disk sleep）:不可中断睡眠（深度睡眠，不可以被唤醒，通常在磁盘写入时发生）
（4）T停止状态（stopped）：可以通过发送SIGSTOP信号给进程来停止进程，可以发送SIGCONT信号让进程继续运行
（5）X死亡状态（dead）:该状态是返回状态，在任务列表中看不到；
（6）Z僵尸状态（zombie）:子进程退出，父进程还在运行，但是父进程没有读到子进程的退出状态，子进程进入僵尸状态；
（7）t追踪停止状态（trancing stop）

> https://zhuanlan.zhihu.com/p/69554144
> https://zhuanlan.zhihu.com/p/104800026
> https://www.zhihu.com/question/376317973