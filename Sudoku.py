board=[
    [7,8,0,4,0,0,1,2,0],
    [6,0,0,0,7,5,0,0,9],
    [0,0,0,6,0,1,0,7,8],
    [0,0,7,0,4,0,2,6,0],
    [0,0,1,0,5,0,9,3,0],
    [9,0,4,0,6,0,0,0,5],
    [0,7,0,3,0,0,0,1,2],
    [1,2,0,0,0,7,4,0,0],
    [0,4,9,2,0,6,0,0,7]
]
def print_board(bo):
    for i in range(len(bo)):
        if i%3==0 and i!=0:
            print("-----------------------")
        for j in range(len(bo[0])):
            if j%3==0 and j!=0:
                print("| ",end=" ")
            print(str(bo[i][j]),end=" ")
        print()
def isValid(bo,num,row,col):
    #check row,col
    for i in range(len(bo)):
        if bo[row][i]==num: return False
        if bo[i][col]==num: return False
    # check 3*3 matrix
    nrow=(row//3)*3
    ncol=(col//3)*3
    for i in range(3):
        for j in range(3):
            if bo[nrow+i][ncol+j]==num: return False
    return True

def sudoku(bo,pos):
    if pos==81:
        print_board(bo)
        return
    row=pos//9
    col=pos%9
    if bo[row][col]==0:
        for i in range(1,10):
            if isValid(bo,i,row,col):
                bo[row][col]=i
                sudoku(bo,pos+1)
                bo[row][col]=0
    else:
        sudoku(bo,pos+1)

print_board(board)
print("Output")
sudoku(board,0)