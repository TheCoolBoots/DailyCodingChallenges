import numpy as np
import pygame as pg


class dot:
    def __init__(self, parent, pos: np.array = np.array(0, 0), vel: np.array = np.array(0, 0),
                 accl: np.array = np.array(0, 0)):
        self.parent = parent
        self.pos = pos
        self.vel = vel
        self.accl = accl

    def move(self):
        self.vel += self.accl
        self.pos += self.vel

    def draw(self):
        pg.draw.circle(self.parent, (255, 255, 255), self.pos, 2)
