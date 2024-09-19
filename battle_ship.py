ships = {
    "c" : {
        "depth" : [1, 0],
        "length" : 4
    },
    "s" : {
        "depth" : [0, 1],
        "length" : 3
    }
}
board = [[[0, 0] for i in range(10)] for i in range(10)]
# board = [
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
#          ]

def show_board():
    print("depth 0: ")
    for i in board:
        for j in i:
            print(j[0], end=" ")
        print("\n")
    print("depth 1: ")
    for i in board:
        for j in i:
            print(j[1], end=" ")
        print("\n")

def place_ship(y, x, type, ori):
    if ori == "v":
        for i in range(ships.get(type, {}).get("length")):
            board[-y - 1 + i][x] = ships.get(type).get("depth")
  
    else:
        for i in range(ships.get(type).get(length)):
            board[-y - 1][x + i] = ships.get(type).get("depth")
# game loop
#--------------------------------------------------------------------------------------
while True:
    ship_type = input("Submarine or carrier (c/s): ")
    if str(ship_type) == "quit":
        break
    elif str(ship_type) not in "cs":
        print("enter something valid!")
        continue

    ship_pos = input("enter x,y coords e.g 4,6: ")
    if ship_type == "quit":
        break
    ship_pos = ship_pos.split(",")
    ship_pos_x, ship_pos_y = ship_pos
    if (int(ship_pos_y) not in range(1, 11)) and (int(ship_pos_x) not in range(1, 11)):
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
