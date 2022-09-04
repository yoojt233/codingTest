package SWEA.no1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
 
        // 방향
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
 
        for (int a = 0; a < tc; a++) {
            // 기본 방향 설정
            int dir = 0;
 
            // 가로 세로
            int h, w;
            h = sc.nextInt();
            w = sc.nextInt();
            char[][] map = new char[h][w];
 
            // 맵 구현
            sc.nextLine();
            for (int i = 0; i < h; i++) {
                String str = sc.nextLine();
                map[i] = str.toCharArray();
            }
 
            // 키 입력
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            char[] keydown = str.toCharArray();
 
            // 탱크 초기 좌표 및 방향 설정
            int x = 0, y = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '^') {
                        x = i;
                        y = j;
                        dir = 0;
                    } else if (map[i][j] == 'v') {
                        x = i;
                        y = j;
                        dir = 1;
                    } else if (map[i][j] == '<') {
                        x = i;
                        y = j;
                        dir = 2;
                    } else if (map[i][j] == '>') {
                        x = i;
                        y = j;
                        dir = 3;
                    }
                }
            }
 
            for (int i = 0; i < n; i++) {
                switch (keydown[i]) {
                case 'U':
                    dir = 0;
                    x += dx[dir];
                    y += dy[dir];
                    if (x >= 0 && x < h && y >= 0 && y < w) {
                        if (map[x][y] == '.') {
                            map[x][y] = '^';
                            map[x - dx[dir]][y - dy[dir]] = '.';
                        } else {
                            x -= dx[dir];
                            y -= dy[dir];
                            map[x][y] = '^';
                        }
                    } else {
                        x -= dx[dir];
                        y -= dy[dir];
                        map[x][y] = '^';
                    }
                    break;
                case 'D':
                    dir = 1;
                    x += dx[dir];
                    y += dy[dir];
                    if (x >= 0 && x < h && y >= 0 && y < w) {
                        if (map[x][y] == '.') {
                            map[x][y] = 'v';
                            map[x - dx[dir]][y - dy[dir]] = '.';
                        } else {
                            x -= dx[dir];
                            y -= dy[dir];
                            map[x][y] = 'v';
                        }
                    } else {
                        x -= dx[dir];
                        y -= dy[dir];
                        map[x][y] = 'v';
                    }
                    break;
                case 'L':
                    dir = 2;
                    x += dx[dir];
                    y += dy[dir];
                    if (x >= 0 && x < h && y >= 0 && y < w) {
                        if (map[x][y] == '.') {
                            map[x][y] = '<';
                            map[x - dx[dir]][y - dy[dir]] = '.';
                        } else {
                            x -= dx[dir];
                            y -= dy[dir];
                            map[x][y] = '<';
                        }
                    } else {
                        x -= dx[dir];
                        y -= dy[dir];
                        map[x][y] = '<';
                    }
                    break;
                case 'R':
                    dir = 3;
                    x += dx[dir];
                    y += dy[dir];
                    if (x >= 0 && x < h && y >= 0 && y < w) {
                        if (map[x][y] == '.') {
                            map[x][y] = '>';
                            map[x - dx[dir]][y - dy[dir]] = '.';
                        } else {
                            x -= dx[dir];
                            y -= dy[dir];
                            map[x][y] = '>';
                        }
                    } else {
                        x -= dx[dir];
                        y -= dy[dir];
                        map[x][y] = '>';
                    }
                    break;
                case 'S':
                    int mx, my;
                    mx = x;
                    my = y;
                    while (true) {
                        mx += dx[dir];
                        my += dy[dir];
                        if (mx >= 0 && mx < h && my >= 0 && my < w) {
                            if (map[mx][my] == '*') {
                                map[mx][my] = '.';
                                break;
                            } else if (mx < 0 || mx >= h || my < 0 || my >= w || map[mx][my] == '#') {
                                mx -= dx[dir];
                                my -= dy[dir];
                                break;
                            } else
                                continue;
                        } else {
                            mx -= dx[dir];
                            my -= dy[dir];
                            break;
                        }
                    }
                    break;
                default:
                    break;
                }
 
            }
 
            // 출력
            System.out.printf("#%d ", a + 1);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.printf("%c", map[i][j]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}