package class153;

// 郁闷的出纳员(C++版)
// 测试链接 : https://www.luogu.com.cn/problem/P1486
// 如下实现是C++的版本，C++版本和java版本逻辑完全一样
// 提交如下代码，可以通过所有测试用例

//#include <iostream>
//#include <cstring>
//#include <algorithm>
//using namespace std;
//
//const int MAXN = 300001;
//
//int head = 0;
//int cnt = 0;
//int key[MAXN];
//int fa[MAXN];
//int ls[MAXN];
//int rs[MAXN];
//int size[MAXN];
//int limit;
//int change = 0;
//int enter = 0;
//
//void up(int i) {
//    size[i] = size[ls[i]] + size[rs[i]] + 1;
//}
//
//int lr(int i) {
//    return rs[fa[i]] == i ? 1 : 0;
//}
//
//void upRotate(int i) {
//    int f = fa[i], g = fa[f], soni = lr(i), sonf = lr(f);
//    if (soni == 1) {
//        rs[f] = ls[i];
//        if (rs[f] != 0) {
//            fa[rs[f]] = f;
//        }
//        ls[i] = f;
//    } else {
//        ls[f] = rs[i];
//        if (ls[f] != 0) {
//            fa[ls[f]] = f;
//        }
//        rs[i] = f;
//    }
//    if (g != 0) {
//        if (sonf == 1) {
//            rs[g] = i;
//        } else {
//            ls[g] = i;
//        }
//    }
//    fa[f] = i;
//    fa[i] = g;
//    up(f);
//    up(i);
//}
//
//void splay(int i, int goal) {
//    int f = fa[i], g = fa[f];
//    while (f != goal) {
//        if (g != goal) {
//            if (lr(i) == lr(f)) {
//                upRotate(f);
//            } else {
//                upRotate(i);
//            }
//        }
//        upRotate(i);
//        f = fa[i];
//        g = fa[f];
//    }
//    if (goal == 0) {
//        head = i;
//    }
//}
//
//void add(int num) {
//    key[++cnt] = num;
//    size[cnt] = 1;
//    if (head == 0) {
//        head = cnt;
//    } else {
//        int f = 0, i = head, son = 0;
//        while (i != 0) {
//            size[i]++;
//            f = i;
//            if (key[i] <= num) {
//                son = 1;
//                i = rs[i];
//            } else {
//                son = 0;
//                i = ls[i];
//            }
//        }
//        if (son == 1) {
//            rs[f] = cnt;
//        } else {
//            ls[f] = cnt;
//        }
//        fa[cnt] = f;
//        splay(cnt, 0);
//    }
//}
//
//int index(int x) {
//    int i = head, last = head;
//    while (i != 0) {
//        last = i;
//        if (size[ls[i]] >= x) {
//            i = ls[i];
//        } else if (size[ls[i]] + 1 < x) {
//            x -= size[ls[i]] + 1;
//            i = rs[i];
//        } else {
//            i = 0;
//        }
//    }
//    splay(last, 0);
//    return key[last];
//}
//
//void departure() {
//    int num = limit - change - 1;
//    int i = head, ans = 0;
//    while (i != 0) {
//        if (key[i] <= num) {
//            ans = i;
//            i = rs[i];
//        } else {
//            i = ls[i];
//        }
//    }
//    if (ans == 0) {
//        return;
//    }
//    splay(ans, 0);
//    head = rs[head];
//    fa[head] = 0;
//}
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    int n, x;
//    char op;
//    cin >> n >> limit;
//    for (int i = 1; i <= n; i++) {
//        cin >> op >> x;
//        if (op == 'I') {
//            if (x >= limit) {
//                enter++;
//                add(x - change);
//            }
//        } else if (op == 'A') {
//            change += x;
//        } else if (op == 'S') {
//            change -= x;
//            departure();
//        } else if (op == 'F') {
//            if (x > size[head]) {
//                cout << -1 << endl;
//            } else {
//                cout << index(size[head] - x + 1) + change << endl;
//            }
//        }
//    }
//    cout << enter - size[head] << endl;
//    return 0;
//}