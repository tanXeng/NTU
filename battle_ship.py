while True:
    ship_type = str(input("Submarine or carrier (c/s): "))
    if ship_type == "quit":
        break
    elif ship_type not in "cs":
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

    ship_dept = input("ship orientation vertical or horizontal (v/h) ")
    if ship_type == "quit":
        break
    elif ship_dept not in "vh":
        print("enter something valid!")
        continue

    ship = (ship_type ,int(ship_pos_x), int(ship_pos_y), ship_dept)
    print(ship)
