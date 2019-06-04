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

#include <src/model/Tile.h>

Tile *vboard;

View::View(Tile **board)
{
    vboard = board;


}

View::~View()
{
    // TODO Auto-generated destructor stub
}

