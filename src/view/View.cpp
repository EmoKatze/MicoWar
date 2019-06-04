/*
 * View.cpp
 *
 *  Created on: 04.06.2019
 *      Author: student
 */

#include <src/view/View.h>
#include "gpio_msp432.h"
#include "spi_msp432.h"
#include "st7735s_drv.h"
#include "uGUI.h"
#include "uGUI_colors.h"
#include "font_4x6.h"
#include "font_5x8.h"
#include "font_5x12.h"
#include "font_6x8.h"
#include "font_6x10.h"
#include "font_7x12.h"
#include "font_8x12.h"

#include <cstdlib>

#include "src/model/Tile.h"

Tile **vboard;
void initScreen();
void redraw();

View::View(Tile **board){
    vboard = board;
    initScreen();
}

#include "gpio_msp432.h"
#include "spi_msp432.h"
#include "st7735s_drv.h"
#include "uGUI.h"

extern const uint16_t realbackground[16384];

void initScreen(){
    // Switch on backlight
    //gpio_msp432_pin lcd_bl (PORT_PIN(2, 6));
    //lcd_bl.gpioMode(GPIO::OUTPUT | GPIO::INIT_HIGH);

    // Setup SPI interface
    gpio_msp432_pin lcd_cs (PORT_PIN(5, 0));
    spi_msp432  spi(EUSCI_B0_SPI, lcd_cs);
    spi.setSpeed(24000000);

    // Setup LCD driver
    gpio_msp432_pin lcd_rst(PORT_PIN(5, 7));
    gpio_msp432_pin lcd_dc (PORT_PIN(3, 7));
    st7735s_drv lcd(spi, lcd_rst, lcd_dc, st7735s_drv::Crystalfontz_128x128);

    // Setup uGUI
    uGUI gui(lcd);

    // Setup bitmap object
    uGUI::BMP bmp;
    bmp.height = 128;
    bmp.width  = 128;
    bmp.p      = realbackground;
    bmp.bpp    = 16;
    bmp.colors = BMP_RGB565;

    // Show bitmap image
    gui.DrawBMP(0, 0, &bmp);


}

View::~View()
{
    // TODO Auto-generated destructor stub
}

