#include "msp.h"
#include <src/model/Tile.h>
#include <src/view/View.h>

Tile **board = new Tile*[6];

//View v (board);

int main(void)
{
    View v(board);
}
