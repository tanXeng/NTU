board = [
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
         ]

def show_board():
    for i in board:
        for j in i:
            print(j, end=" ")
        print("\n")

def place_ship(y, x, type, ori):
    if ori == "v":
        if type == "c":
            board[-y - 1][x] = 1
            board[-y    ][x] = 1
            board[-y + 1][x] = 1
            board[-y + 2][x] = 1
        else:
            board[-y - 1][x] = 1
            board[-y - 2][x] = 1
            board[-y - 3][x] = 1
    else:
        if type == "c":
            board[-y - 1][x] = 1
            board[-y - 1][x + 1] = 1
            board[-y - 1][x + 2] = 1
            board[-y - 1][x + 3] = 1
        else:
            board[-y - 1][x] = 1
            board[-y - 1][x + 1] = 1
            board[-y - 1][x + 2] = 1

while True:
    ship_type = input("Submarine or carrier (c/s): ")
    if str(ship_type) == "quit":
        break
    elif str(ship_type) not in "cs":
        print("enter something valid!")
        continue

    ship_pos_y = input("enter y coords: ")
    if ship_type == "quit":
        break
    elif int(ship_pos_y) not in range(1, 11):
        print("enter something valid!")
        continue

    ship_pos_x = input("enter x coords ")
    if ship_type == "quit":
        break
    elif int(ship_pos_x) not in range(1, 11):
        print("enter something valid!")
        continue

    ship_ori = input("ship orientation vertical or horizontal (v/h) ")
    if ship_type == "quit":
        break
    elif ship_ori not in "vh":
        print("enter something valid!")
        continue

    place_ship(int(ship_pos_y), int(ship_pos_x), ship_type, ship_ori)
    show_board()
