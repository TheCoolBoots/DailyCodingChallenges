from time import sleep
from typing import List
import pygame as pg
import numpy as np


class brain:

    def __init__(self, width, height, numDots = 10):
        pg.init()
        screen = pg.display.set_mode((height, width))
        screen.fill([255, 255, 255])
        pg.display.update()
        count = 0
        while count < 10:
            count += 1
            sleep(1)


if __name__ == '__main__':
    b = brain(100, 200)
